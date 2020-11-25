package hu.gov.allamkincstar.webservices.dummyauthentication.util;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import javax.inject.Inject;
import java.util.Objects;

public class AuthenticationInterceptor extends AbstractSoapInterceptor {

    @Inject
    private AuthenticationUserEJB serviceAuthenticate;

    // a NoArg konstruktorban meghívjuk a szülőt, és itt tudjuk
    // megmondani, hogy melyik fázisban akarunk beleugatni a protokollba
    public AuthenticationInterceptor() {
        super(Phase.USER_PROTOCOL);
    }

    @Inject
    private ConfigurationProvider servicCredential;

    @Override
    public void handleMessage(SoapMessage soapMessage) throws Fault {

        AuthorizationPolicy policy = soapMessage.get(AuthorizationPolicy.class);

        if (Objects.isNull(policy)) throw new RuntimeException("Unauthorized call");

        String username = policy.getUserName();
        String password = policy.getPassword();
        if (username == null || password == null)
            throw new RuntimeException(String.format("Invalid username or password for user %s", username.toString()));

        boolean isLoginValid = checkLoginIklPU(username, password);
        isLoginValid = isLoginValid || checkLoginWildfly(username, password);

        if (!isLoginValid)
            throw new RuntimeException(String.format("Invalid username or password for user %s", username.toString()));

    }

    private boolean checkLoginIklPU(String username, String password){
        serviceAuthenticate = javax.enterprise.inject.spi.CDI.current().select(AuthenticationUserEJB.class).get();
        return serviceAuthenticate.checkPasswordIklPU(username, password);
    }

    private boolean checkLoginWildfly(String username, String password){
        serviceAuthenticate = javax.enterprise.inject.spi.CDI.current().select(AuthenticationUserEJB.class).get();
        return (username.equals(servicCredential.getWebserviceUserName()) &&
                password.equals(servicCredential.getWebservicePassword()));
    }

}

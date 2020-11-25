package hu.gov.allamkincstar.webservices.dummyauthentication.service;

import hu.gov.allamkincstar.webservices.dummyauthentication.model.response.DummyRequest;
import hu.gov.allamkincstar.webservices.dummyauthentication.model.response.DummyResponse;
import hu.gov.allamkincstar.webservices.dummyauthentication.model.response.ObjectFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.interceptor.InInterceptors;

import javax.ejb.Stateless;
import javax.jws.WebService;

@Slf4j
@Stateless
@WebService(serviceName = "DummyAuthenticationWebservice",
        targetNamespace="http://dummyauthentication.webservices.allamkincstar.gov.hu/",
        endpointInterface = "hu.gov.allamkincstar.webservices.dummyauthentication.service.DummyAuthenticationInterface")
@InInterceptors(interceptors = {"hu.gov.allamkincstar.webservices.dummyauthentication.util.AuthenticationInterceptor"})
public class DummyAuthentication  implements DummyAuthenticationInterface{
    @Override
    public DummyResponse authenticationService(DummyRequest request) {
        DummyResponse response = new ObjectFactory().createDummyResponse();
        response.setResponse("Minden OK");
        return response;
    }
}

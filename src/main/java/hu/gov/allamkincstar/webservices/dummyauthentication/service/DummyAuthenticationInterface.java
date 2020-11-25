package hu.gov.allamkincstar.webservices.dummyauthentication.service;

import hu.gov.allamkincstar.webservices.dummyauthentication.model.response.DummyRequest;
import hu.gov.allamkincstar.webservices.dummyauthentication.model.response.DummyResponse;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.rmi.Remote;
import java.rmi.RemoteException;

@WebService(name = "DummyAuthenticationWebservice", targetNamespace="http://dummyauthentication.webservices.allamkincstar.gov.hu/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    hu.gov.allamkincstar.webservices.dummyauthentication.model.response.ObjectFactory.class
})
//public interface DummyAuthenticationInterface extends Remote {
public interface DummyAuthenticationInterface extends Remote {

    @WebMethod(operationName = "dummyKeres")
    DummyResponse authenticationService(@WebParam DummyRequest request);

}

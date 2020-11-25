package hu.gov.allamkincstar.webservices.dummyauthentication.util;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import lombok.Getter;

@Singleton
@Startup
@Getter
public class ConfigurationProvider {
    @Resource(name = "java:/comp/env/webserviceUserName")
    private String webserviceUserName;
    
    @Resource(name = "java:/comp/env/webservicePassword")
    private String webservicePassword;
    
    @Resource(name = "java:/comp/env/webserviceEndpointAddress")
    private String endpointAddress;
    
}

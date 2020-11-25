package hu.gov.allamkincstar.webservices.dummyauthentication.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthenticationData {
    private String username;
    private String password;
}

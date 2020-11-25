package hu.gov.allamkincstar.webservices.dummyauthentication.util;

import hu.gov.allamkincstar.webservices.dummyauthentication.entities.Szemely;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class AuthenticationUserEJB {

    @PersistenceContext(name = "iklPU")
    private EntityManager entityManagerIKL;

    public boolean checkPasswordIklPU(String userName, String pw){
        TypedQuery<Szemely> typedQuery = entityManagerIKL.createNamedQuery("Szemely.findByAdoazon",Szemely.class);
        Szemely szemely = typedQuery.getSingleResult();
        if (szemely == null) return false;
        return (szemely.getInev().equals(pw));
    }

}

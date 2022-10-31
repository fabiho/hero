package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ManagedBean
@ApplicationScoped
public class Hero {
    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("country");

    public Hero(){

    }

    public List<Country> getEmissions() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Country c");
        List<Country> countryList = q.getResultList();
        return countryList;
    }
}

package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class HeroBean implements Serializable {
    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hero");

    public HeroBean(){

    }

    public List<Country> getEmissions() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Country c");
        List<Country> country = q.getResultList();
        String x = "Hello World";
        return country;
    }
}

package controller;

import jakarta.persistence.*;
import model.Country;

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

    public List<Country> getCountrys() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Country c");
        List<Country> country = q.getResultList();
        return country;
    }

    public void saveCountry (Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(country);
        t.commit();
    }

}

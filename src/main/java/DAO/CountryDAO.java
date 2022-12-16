package DAO;

import jakarta.persistence.*;
import model.Country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CountryDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hero");

    public List<Country> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query abfrage = entityManager.createQuery("select c from Country c");
        List<Country> allCountry = abfrage.getResultList();
        entityManager.close();
        return allCountry;
    }


    public void saveCountry (Country country) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(country);
        t.commit();
        em.close();
    }



}

package DAO;

import jakarta.persistence.*;
import Entity.Country;
import jakarta.transaction.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CountryDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hero");
    private EntityManager em;

    @PostConstruct
    public void initialize() {
        em = emf.createEntityManager();
    }

    public List<Country> findAll() {
        Query abfrage = em.createQuery("select c from Country c");
        List<Country> allCountry = abfrage.getResultList();
        return allCountry;
    }

    @Transactional
    public void saveCountry (Country country) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(country);
        t.commit();
    }



}

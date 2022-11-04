package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Named
public class CountryDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hero");

    public List<Country> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        Query abfrage = entityManager.createQuery("select c from Country c");
        List<Country> allCountry = abfrage.getResultList();
        entityManager.close();
        return allCountry;
    }

}

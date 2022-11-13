package DAO;

import jakarta.persistence.*;
import model.User;

import java.util.List;

public class UserDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hero");

    public List<User> allUsers() {
        EntityManager entityManager = emf.createEntityManager();
        Query abfrage = entityManager.createQuery("select u from User u");
        List<User> allUsers = abfrage.getResultList();
        entityManager.close();
        return allUsers;
    }

    public void createUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(user);
        t.commit();
    }
}

package DAO;

import Entity.User;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.sql.SQLException;
import java.util.List;

@Named
@ApplicationScoped
public class UserDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("hero");
    private EntityManager em;

    @PostConstruct
    public void initialize() {
        em = emf.createEntityManager();
    }


    public List<User> allUsers() {
        Query abfrage = em.createQuery("select u from User u");
        List<User> allUsers = abfrage.getResultList();
        return allUsers;
    }

    public User findUser(String mail, String passwort) throws SQLException {
        Query abfrage = em.createQuery("select u from User u where u.mail = :mail AND u.passwort = :passwort");
        abfrage.setParameter("mail", mail);
        abfrage.setParameter("passwort", passwort);
        try {
            return (User) abfrage.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }

    @Transactional
    public String createUser(User user) throws Exception {
        try {
            em.persist(user);
            FacesContext.getCurrentInstance().addMessage(
                    "regInfo",
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Die Registrierung war erfolgreich",
                            "Melde dich jetzt direkt an")
            );
            return "login";
        } catch (Exception regException) {
            System.out.println("Registration error -->" + regException.getMessage());

            FacesContext.getCurrentInstance().addMessage(
                    "regInfo",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Die Registrierung ist fehlgeschlagen",
                            "Die Mailadresse existiert bereits"));
        }

        return "reg";

    }

    @Transactional
    public void saveUser (User user) {
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.merge(user);
        t.commit();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Änderung erfolgreich",
                "Deine Profilinformationen wurde geändert"));
    }

}

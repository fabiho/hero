package DAO;

import Login.DataConnect;
import jakarta.persistence.*;
import model.User;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named("userDAO")
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

    public String createUser(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(user);
        t.commit();
        em.close();
        FacesContext.getCurrentInstance().addMessage(
                "reg-info",
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Die Registrierung war erfolgreich",
                        "Melde dich jetzt direkt an")
        );
        return "login";
    }

    public static boolean validate(String mail, String passwort) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select mail, passwort from USER where mail = ? and passwort = ?");
            ps.setString(1, mail);
            ps.setString(2, passwort);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close((org.mariadb.jdbc.Connection) con);
        }
        return false;
    }
}

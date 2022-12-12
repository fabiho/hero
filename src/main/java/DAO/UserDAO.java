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

    public static User validate(String mail, String passwort) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        User validUser = null;

        try {
            con = DataConnect.getConnection();
            ps = con.prepareStatement("Select anrede,vorname,nachname,firma,position,mail,passwort from USER where mail = ? and passwort = ?");
            ps.setString(1, mail);
            ps.setString(2, passwort);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                //result found, means valid inputs
                validUser = new User();
                validUser.setAnrede(rs.getString("anrede"));
                validUser.setVorname(rs.getString("vorname"));
                validUser.setNachname(rs.getString("nachname"));
                validUser.setFirma(rs.getString("firma"));
                validUser.setPosition(rs.getString("position"));
                validUser.setMail(rs.getString("mail"));
                validUser.setPasswort(rs.getString("passwort"));
                return validUser;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
        } finally {
            DataConnect.close((org.mariadb.jdbc.Connection) con);
        }
        return null;
    }
}

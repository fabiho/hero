package model;

import DAO.UserDAO;
import Login.SessionUtils;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@SessionScoped
@Named
@Entity
public class User implements Serializable {

    @Id
    private Integer userId;
    private String anrede;
    private String vorname;
    private String nachname;
    private String firma;
    private String position;
    private String mail;
    private String passwort;

    private static Boolean isLoggedIn = false;

    public User() {

    }

    //validate Login
    public String validateUsernamePassword() {
        boolean valid = UserDAO.validate(mail, passwort);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("name", mail);
            setIsLoggedIn(true);
            return "user";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    "loginMessage",
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Die eingegebene Mail oder das Passwort ist falsch",
                            "Bitte gib eine korrekte Mail oder Passwort ein")
            );
            return "login";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        setIsLoggedIn(false);
        return "login";
    }

    public boolean isLoggedIn(){
        return isLoggedIn; //always false by default
    }

    //add User
    public String addNewUser(String anrede, String vorname, String nachname, String firma, String position, String mail, String passwort) {
        String s = UserDAO.create(anrede, vorname, nachname, firma, position, mail, passwort);
        return s;
    }

    // Gett + Setter
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getAnrede() {
        return anrede;
    }
    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getFirma() {
        return firma;
    }
    public void setFirma(String firma) {
        this.firma = firma;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    public static Boolean getIsLoggedIn() {
        return isLoggedIn;
    }
    public static void setIsLoggedIn(Boolean isLoggedIn) {
        User.isLoggedIn = isLoggedIn;
    }
}

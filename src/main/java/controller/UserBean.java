package controller;

import DAO.UserDAO;
import Login.SessionUtils;
import model.User;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

@ViewScoped
@Named
public class UserBean implements Serializable {

    private String mail;
    private String passwort;

    private static Boolean isLoggedIn = false;

    @Inject
    private User user;

    @PostConstruct
    public void init() {

        mail = user.getMail();
        passwort = user.getPasswort();

    }

    //validate Login
    public String validateUsernamePassword() throws SQLException {
        User validUser = UserDAO.validate(mail, passwort);
        if (validUser != null) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("name", mail);
            setIsLoggedIn(true);
            user.setAnrede(validUser.getAnrede());
            user.setVorname(validUser.getVorname());
            user.setNachname(validUser.getNachname());
            user.setFirma(validUser.getFirma());
            user.setPosition(validUser.getPosition());
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

    // Gett + Setter
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
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
        UserBean.isLoggedIn = isLoggedIn;
    }

}

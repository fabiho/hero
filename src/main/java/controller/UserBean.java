package controller;

import DAO.UserDAO;
import Login.SessionUtils;
import Entity.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.sql.SQLException;

@SessionScoped
@Named
public class UserBean implements Serializable {

    private String mail;
    private String passwort;

    private static Boolean isLoggedIn = false;

    private User user;

    @Inject
    private UserDAO userDAO;

    @PostConstruct
    public void init() {

    }

    //validate Login
    public String validateUsernamePassword() throws SQLException {
        User validUser = userDAO.findUser(mail, passwort);
        if (validUser != null) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("name", mail);
            setIsLoggedIn(true);
            user = validUser;
            return "user?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    "regInfo",
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

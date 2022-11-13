package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private Integer userId;
    private String anrede;
    private String vorname;
    private String nachname;
    private String firma;
    private String position;
    private String mail;
    private String passwort;

    public User() {

    }

    public User(Integer userId, String anrede, String vorname, String nachname, String firma, String position, String mail, String passwort) {
        this.userId = userId;
        this.anrede = anrede;
        this.vorname = vorname;
        this.nachname = nachname;
        this.firma = firma;
        this.position = position;
        this.mail = mail;
        this.passwort = passwort;
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
}

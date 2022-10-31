package model;

import jakarta.persistence.*;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ManagedBean
@ApplicationScoped
@Entity
public class Country implements Serializable {
    @Id
    private String country_code = "SERVUS";
    private String country_name;
    private double y1990;
    private double y1991;
    private double y1992;
    private double y1993;
    private double y1994;
    private double y1995;
    private double y1996;
    private double y1997;
    private double y1998;
    private double y1999;
    private double y2000;
    private double y2001;
    private double y2002;
    private double y2003;

    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("country");

    public Country() {

    }

    public List<Country> getEmissions() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select c from Country c");
        List<Country> countryList = q.getResultList();
        return countryList;
    }

    public String getCountry_id() {
        return country_code;
    }

    public void setCountry_id(String country_id) {
        this.country_code = country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public double getY1990() {
        return y1990;
    }

    public void setY1990(double y1990) {
        this.y1990 = y1990;
    }

    public double getY1991() {
        return y1991;
    }

    public void setY1991(double y1991) {
        this.y1991 = y1991;
    }

    public double getY1992() {
        return y1992;
    }

    public void setY1992(double y1992) {
        this.y1992 = y1992;
    }

    public double getY1993() {
        return y1993;
    }

    public void setY1993(double y1993) {
        this.y1993 = y1993;
    }

    public double getY1994() {
        return y1994;
    }

    public void setY1994(double y1994) {
        this.y1994 = y1994;
    }

    public double getY1995() {
        return y1995;
    }

    public void setY1995(double y1995) {
        this.y1995 = y1995;
    }
}

package controller;

import DAO.CountryDAO;
import Service.ChartJsView;
import Entity.Country;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CountryBean implements Serializable {

    private Country selectedCountry;
    private String selectedCountryCode;
    private List<Country> countries;

    @Inject
    private CountryDAO service;

    @Inject
    private ChartJsView chartJsView;

    @PostConstruct
    public void init() {

        countries = service.findAll();
        selectedCountryCode = countries.get(0).getCountry_code();
        onChange();
    }

    public void onChange() {
        this.selectedCountry = countries.stream()
                .filter(co -> co.getCountry_code().equals(selectedCountryCode))
                .findAny()
                .orElse(null);
        chartJsView.createLineModel(selectedCountry);
        chartJsView.createBarModel(selectedCountry);
    }

    //Getter + Setter
    public Country getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(Country selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public String getSelectedCountryCode() {
        return selectedCountryCode;
    }

    public void setSelectedCountryCode(String selectedCountryCode) {
        this.selectedCountryCode = selectedCountryCode;
    }

    public List<Country> getCountries() {
        return countries;
    }
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
    public CountryDAO getService() {
        return service;
    }
    public void setService(CountryDAO service) {
        this.service = service;
    }

}

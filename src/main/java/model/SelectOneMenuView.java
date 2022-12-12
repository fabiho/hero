package model;

import DAO.CountryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class SelectOneMenuView {

    private String selectedOption;
    private String rtl;
    private String hideNoSelectOption;

    private Country selectedCountry;
    private List<Country> countries;

    private String year;
    private List<String> years;

    private String option;
    private List<String> options;

    private String longItemLabel;
    private String labeled;

    @Inject
    private CountryDAO service;

    @PostConstruct
    public void init() {

        //countries
        countries = service.findAll();

        //options
        options = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            options.add("Option " + i);
        }
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public String getRtl() {
        return rtl;
    }

    public String getHideNoSelectOption() {
        return hideNoSelectOption;
    }

    public void setHideNoSelectOption(String hideNoSelectOption) {
        this.hideNoSelectOption = hideNoSelectOption;
    }

    public void setRtl(String rtl) {
        this.rtl = rtl;
    }

    public Country getSelectedCountry() {
        return selectedCountry;
    }

    public void setSelectedCountry(Country selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getLongItemLabel() {
        return longItemLabel;
    }

    public void setLongItemLabel(String longItemLabel) {
        this.longItemLabel = longItemLabel;
    }

    public String getLabeled() {
        return labeled;
    }

    public void setLabeled(String labeled) {
        this.labeled = labeled;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<String> getYears() {
        return years;
    }

    public void setYears(List<String> years) {
        this.years = years;
    }
}

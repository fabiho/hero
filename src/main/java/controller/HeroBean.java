package controller;

import model.Country;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ManagedBean
@SessionScoped
public class HeroBean implements Serializable {

    private Country selected;
    private List <Country> selectedCountry = new ArrayList<>();

    public void selectCountry (Country country) {
        selectedCountry.clear();
        selectedCountry.add(country);
        String x = "Hello World";
    }

    public boolean isSelected(Country country) {
        return selectedCountry.contains(country);
    }

    //Getter + Setter
    public Country getSelected() {
        return selected;
    }
    public void setSelected(Country selected) {
        this.selected = selected;
    }
    public List<Country> getSelectedCountry() {
        return selectedCountry;
    }
    public void setSelectedCountry(List<Country> selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

}

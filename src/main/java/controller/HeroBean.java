package controller;

import model.Country;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class HeroBean implements Serializable {

    private List <Country> selectedCountry = new ArrayList<>();

    public void selectCountry (Country country) {
        selectedCountry.clear();
        selectedCountry.add(country);
        String x = "Hello World";
    }

    //Getter + Setter
    public List<Country> getSelectedCountry() {
        return selectedCountry;
    }
    public void setSelectedCountry(List<Country> selectedCountry) {
        this.selectedCountry = selectedCountry;
    }

}

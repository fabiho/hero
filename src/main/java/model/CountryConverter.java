package model;

import DAO.CountryDAO;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.List;

@FacesConverter("countryConverter")
public class CountryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context,
                              UIComponent component,
                              String value) {
        //prepare your datasource ex. EJB .. etc
        if (value.trim().equals("")) {
            return null;
        } else {
            CountryDAO service = new CountryDAO();
            List<Country> countries = service.findAll();

            for(Country country : countries) {
                if(country.getCountry_name().equals(value)) {
                    return country;
                }
            }
            return countries;
        }

    }

    @Override
    public String getAsString(FacesContext context,
                              UIComponent component,
                              Object value)   {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((Country) value).getCountry_name());
        }
    }


}

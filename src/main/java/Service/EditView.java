package Service;

import DAO.CountryDAO;
import Entity.Country;
import org.primefaces.event.RowEditEvent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("dtEditView")
@RequestScoped
public class EditView implements Serializable {

    private List<Country> countryList;


    @Inject
    private CountryDAO service;

    @PostConstruct
    public void init() {
        countryList = service.findAll();

    }


    // Getter + Setter
    public List<Country> getCountryList() {
        return countryList;
    }
    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }
    public CountryDAO getService() {
        return service;
    }
    public void setService(CountryDAO service) {
        this.service = service;
    }


    public void onRowEdit(RowEditEvent<Country> event) {
        FacesMessage msg = new FacesMessage("Land gespeichert",
                String.valueOf(event.getObject().getCountry_name()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
        service.saveCountry(event.getObject());
    }

    public void onRowCancel(RowEditEvent<Country> event) {
        FacesMessage msg = new FacesMessage("Bearbeitung abgebrochen",
                String.valueOf(event.getObject().getCountry_name()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}

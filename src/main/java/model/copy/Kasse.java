package model.copy;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class Kasse {

    private boolean value1 = true;
    private boolean value2;


    public boolean isValue1() {
        return value1;
    }

    public void setValue1(boolean value1) {
        this.value1 = value1;
    }

    public boolean isValue2() {
        return value2;
    }

    public void setValue2(boolean value2) {
        this.value2 = value2;
    }

    public void toggleKartenzahlung() {
        value2 = !value1;
        String summary = value1 ? "Kartenzahlung ausgewählt" : "Barzahlung ausgewählt";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    public void toggleBarzahlung() {
        value1 = !value2;
        String summary = value2 ? "Barzahlung ausgewählt" : "Kartenzahlung ausgewählt";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
}
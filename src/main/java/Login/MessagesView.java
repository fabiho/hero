package Login;

import model.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MessagesView {

    private String anrede;
    private String vorname;
    private String nachname;

    @Inject
    private User user;

    @PostConstruct
    public void init() {

        anrede = user.getAnrede();
        vorname = user.getVorname();
        nachname = user.getNachname();

    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Hallo " + anrede + " " + vorname + " " + nachname,
                "Als angemeldeter Benutzer kannst du neue Daten hinzufügen oder Datenfehler korrigieren"));
    }

    public void success() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Registrierung erfolgreich",
                "Melde dich jetzt direkt an"));
    }

    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Message Content"));
    }

    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Message Content."));
    }
}

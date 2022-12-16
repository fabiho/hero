package Login;

import controller.UserBean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class MessagesView implements Serializable {

    private String anrede;
    private String vorname;
    private String nachname;

    @Inject
    private UserBean userBean;

    @PostConstruct
    public void init() {

        anrede = userBean.getUser().getAnrede();
        vorname = userBean.getUser().getVorname();
        nachname = userBean.getUser().getNachname();

    }

    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Hallo " + vorname,
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

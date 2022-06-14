import model.Hotdog;
import model.Zutat;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ManagedBean
@SessionScoped
public class Bestellung implements Serializable {

    double sum;
    private Hotdog selected;
    private List <Hotdog> warenkorb = new ArrayList<>();
    private List <Zutat> hotdogzutaten = new ArrayList<>();
    private List <Zutat> zutaten = new ArrayList<>();

    @PostConstruct
    public void init () {
        zutaten.add(Zutat.basic);
        zutaten.add(Zutat.guerkchen);
        zutaten.add(Zutat.roestzwiebln);
        zutaten.add(Zutat.kaese);
        zutaten.add(Zutat.avocado);
        zutaten.add(Zutat.limette);
        zutaten.add(Zutat.senf);
        zutaten.add(Zutat.ketchup);
        zutaten.add(Zutat.siracha);
        hotdogzutaten.add(Zutat.basic);
    }

    public void selectZutat(Zutat zutat) {
        if (hotdogzutaten.contains(zutat)) {
            hotdogzutaten.remove(zutat);
        } else {
            hotdogzutaten.add(zutat);
        }
    }

    public void warenkorb() {
        if(selected == null) {
            Hotdog hotdog = new Hotdog("Hotdog", hotdogzutaten);
            hotdogzutaten = new ArrayList<>();
            warenkorb.add(hotdog);
        } else {
            selected = null;
            hotdogzutaten = new ArrayList<>();
        }
        hotdogzutaten.add(Zutat.basic);
    }

    public void deleteHotdog(Hotdog hotdog){
        selected = hotdog;
        warenkorb.remove(hotdog);
        hotdogzutaten.removeAll(selected.getZutatenList());
        selected = null;
        hotdogzutaten.add(Zutat.basic);
    }

    public void edit(Hotdog hotdog){
        selected = hotdog;
        hotdogzutaten = selected.getZutatenList();
    }

    public boolean isSelected(Zutat zutat) {
       return hotdogzutaten.contains(zutat);
    }

    public String sum(){
        sum = 0.00;
        double newBetrag;
        for(Hotdog hotdog : warenkorb){
            for (Zutat zutat : hotdog.getZutatenList()) {
                newBetrag = zutat.getBetrag() - (zutat.getBetrag() * (hotdog.discount(zutat)/100.00));
                sum = sum + newBetrag;
            }
        }
        return String.format("%.2f", sum);
    }


    //Getter + Setter
    public List<Hotdog> getWarenkorb() {
        return this.warenkorb;
    }
    public void setWarenkorb(List<Hotdog> warenkorb) {
        this.warenkorb = warenkorb;
    }
    public List<Zutat> getHotdogzutaten() {
        return this.hotdogzutaten;
    }
    public void setHotdogzutaten(List<Zutat> hotdogzutaten) {
        this.hotdogzutaten = hotdogzutaten;
    }
    public List<Zutat> getZutaten() {
        return this.zutaten;
    }
    public void setZutaten(List<Zutat> zutaten) {
        this.zutaten = zutaten;
    }
    public double getSum() {
        return sum;
    }
    public void setSum(double sum) {
        this.sum = sum;
    }
    public Hotdog getSelected() {
        return selected;
    }
    public void setSelected(Hotdog selected) {
        this.selected = selected;
    }
}


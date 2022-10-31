package model.copy;

public enum Zutat {
    basic("Basic", 1.00,"img/hotdog.jpg"),
    guerkchen("Gürkchen",0.50,"img/cucumber.jpg"),
    roestzwiebln("Röstzwiebeln",0.50,"img/onion.jpg"),
    avocado("Avocado",1.00,"img/avocado.jpg"),
    limette("Limette",0.80,"img/limette.jpg"),
    senf("Senf",0.20,"img/mustard.jpg"),
    ketchup("Ketchup",0.20,"img/ketchup.jpg"),
    siracha("Siracha",0.20,"img/siracha.jpeg"),
    kaese("Käse", 0.50,"img/kaese.jpg");

    private String name;
    private double betrag;
    private String bild;

    Zutat(String name, double betrag, String bild) {
        this.name = name;
        this.betrag = betrag;
        this.bild = bild;
    }

    //Getter + Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBetrag() {
        return betrag;
    }
    public String getStringBetrag() {
        return String.format("%.2f", this.betrag);
    }
    public void setBetrag(double betrag) {
        this.betrag = betrag;
    }
    public String getBild() {
        return bild;
    }
    public void setBild(String bild) {
        this.bild = bild;
    }
}

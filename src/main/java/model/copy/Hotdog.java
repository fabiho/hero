package model.copy;

import java.util.List;

public class Hotdog {
    private String name;
    private List<Zutat> zutatenList;

    public Hotdog(String name, List<Zutat> zutatenList) {
        this.name = name;
        this.zutatenList = zutatenList;
    }

    public int discount(Zutat zutat){
        int index = zutatenList.indexOf(zutat);
        if(index <= 4) {
            return index * 10;
        } else {
            return 50;
        }
    }

    //Getter + Setter
    public List<Zutat> getZutatenList() {
        return zutatenList;
    }
    public void setZutatenList(List<Zutat> zutatenList) {
        this.zutatenList = zutatenList;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

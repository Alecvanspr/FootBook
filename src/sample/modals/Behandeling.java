package sample.modals;

import java.util.ArrayList;

public class Behandeling {
    public String id;
    public String naam;
    public String omschrijving;
    public double kosten;
    public Behandeling(ArrayList<String> data){
        this.id = data.get(0);
        this.naam = data.get(1);
        this.omschrijving = data.get(2);
        this.kosten =Double.parseDouble(data.get(3));
    }
}

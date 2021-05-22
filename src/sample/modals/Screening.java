package sample.modals;

import sample.Database.Context;
import sample.Database.DateMaker;

import java.util.ArrayList;
import java.util.Date;

public class Screening {
    public Context context = Context.getContext();
    public Date datum;
    public Boolean koudeVoeten;
    public String gevoelR;
    public String opmerkingGevoelR;
    public String gevoelL;
    public String opmerkingGevoelL;

    public Screening(ArrayList<String> data){
        datum = DateMaker.maakDate(data.get(0));
        koudeVoeten = Boolean.parseBoolean(data.get(1));
        gevoelR = data.get(2);
        opmerkingGevoelR = data.get(3);
        gevoelL = data.get(4);
        opmerkingGevoelL = data.get(5);
    }
}

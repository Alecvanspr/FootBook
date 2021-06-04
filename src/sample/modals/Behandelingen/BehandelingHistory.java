package sample.modals.Behandelingen;

import sample.Database.ContextClasses.Context;
import sample.Database.Tools.DateMaker;

import java.util.ArrayList;
import java.util.Date;

public class BehandelingHistory {
    public Date datum;
    public Behandeling type;
    public String bijzonderheden;
    //bijverkoop
    public BehandelingHistory(ArrayList<String> data){
            this.datum = DateMaker.maakDate(data.get(0));
            this.type = Context.getBehandelingen().get(data.get(1));
            this.bijzonderheden = data.get(2);
    }

}

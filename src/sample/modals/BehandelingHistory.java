package sample.modals;

import sample.Database.Context;
import sample.Database.DateMaker;

import java.util.ArrayList;
import java.util.Date;

public class BehandelingHistory {
    public Date datum;
    public Behandeling type;
    public String bijzonderheden;
    //bijverkoop
    public BehandelingHistory(ArrayList<String> data){
            this.datum = DateMaker.maakDate(data.get(0));
            this.type = Context.getBehandelingen().getBehandeling(data.get(1));
            this.bijzonderheden = data.get(2);
    }

}

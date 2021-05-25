package sample.FX.KlantenScherm;

import javafx.scene.control.ComboBox;
import sample.Database.Context;

public class AddBehandelingHistory {
    public ComboBox BehandelingBox;
    private Context context;

    public void load(){
        context = Context.getContext();
        BehandelingBox.getItems().addAll(context.getBehandelingen().getBehandelingen());
    }
}

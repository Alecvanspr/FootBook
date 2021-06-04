package sample.FX.Behandelingen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;
import sample.Database.Managers.FileUpdater;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class EditBehandeling {
    @FXML
    private TextField naam,omschrijving,prijs;
    private int id;

    public void load(int id){
        this.id = id;
        naam.setText(Context.getBehandelingen().getList().get(id).naam);
        omschrijving.setText(Context.getBehandelingen().getList().get(id).omschrijving);
        prijs.setText(Context.getBehandelingen().getList().get(id).kosten+"");
    }

    public void slaOp() throws IOException {
        if(checkLeeg()){
            save();
            updateList();
            gaNaarBehandelingsOverzicht();
        }
    }
    private void save(){
        FileUpdater updater = new FileUpdater();
        updater.updateFile("src/db/behandelingen/"+getData().get(0)+".txt",getData());
    }
    private void updateList(){
        Context.getBehandelingen().getList().get(id).naam = naam.getText();
        Context.getBehandelingen().getList().get(id).omschrijving = omschrijving.getText();
        Context.getBehandelingen().getList().get(id).kosten = Double.parseDouble(prijs.getText());
    }
    private ArrayList<String> getData(){
        ArrayList<String> ret = new ArrayList();
        ret.add(Context.getBehandelingen().getList().get(id).id);
        ret.add(naam.getText());
        ret.add(omschrijving.getText());
        ret.add(prijs.getText());
        return ret;
    }
    private Boolean checkLeeg(){
        if(naam.getText()==null||
                omschrijving.getText()==null||prijs.getText().equals("0.00")){
            return false;
        }
        return true;
    }

    public void gaNaarBehandelingsOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Behandelingen/BehandelingsOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        BehandelingsOverzicht controller = (BehandelingsOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)naam.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

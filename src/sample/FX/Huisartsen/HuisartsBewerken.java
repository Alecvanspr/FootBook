package sample.FX.Huisartsen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.modals.Huisarts;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class HuisartsBewerken {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,plaatsfld,Huisartenfld,Telefoonfld,Websitefld,emailfld;
    @FXML
    private Label ErrorLabel;

    private Context context = Context.getContext();
    private int id;

    public void load(int id){
        this.id = id;
        Huisarts huisarts= context.getHuisartsen().getHuisartsen().get(id);
        NaamFld.setText(huisarts.naam);
        straatfld.setText(huisarts.adres);
        postcodefld.setText(huisarts.postcode);
        plaatsfld.setText(huisarts.plaats);
        Huisartenfld.setText(huisarts.huisartsenpost);
        Telefoonfld.setText(huisarts.telefoonnr);
        Websitefld.setText(huisarts.website);
        emailfld.setText(huisarts.email);
    }

    public void slaOp() throws IOException {
        if(!isLeeg()) {
            context.getHuisartsen().editHuisarts(getData());
            gaNaarHuisartenOverzicht();
        }else{
            ErrorLabel.setVisible(true);
        }
    }
    private Boolean isLeeg(){
        System.out.println(isLeeg(NaamFld)&&isLeeg(straatfld)&&isLeeg(postcodefld)&&isLeeg(plaatsfld)&&isLeeg(Huisartenfld)&&isLeeg(Telefoonfld)&&isLeeg(Websitefld)&&isLeeg(emailfld));
        if(isLeeg(NaamFld)&&isLeeg(straatfld)&&isLeeg(postcodefld)&&isLeeg(plaatsfld)&&isLeeg(Huisartenfld)&&isLeeg(Telefoonfld)&&isLeeg(Websitefld)&&isLeeg(emailfld))
            return false;
        return true;
    }
    private boolean isLeeg(TextField textField){
        if(textField.getText().equals(""))
            return false;
        return true;
    }
    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(context.getHuisartsen().getHuisartsen().get(id).id);
        data.add(NaamFld.getText());
        data.add(Telefoonfld.getText());
        data.add(straatfld.getText());
        data.add(postcodefld.getText());
        data.add(plaatsfld.getText());
        data.add(emailfld.getText());
        data.add(Huisartenfld.getText());
        data.add(Websitefld.getText());
        data.add("-");
        return data;
    }

    public void gaNaarHuisartenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Huisartsen/HuisartsenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        HuisartsenOverzicht controller =(HuisartsenOverzicht) fxmlLoader.getController();
        controller.loadHuisartsen();

        Stage window = (Stage)NaamFld.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

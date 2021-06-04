package sample.FX.Huisartsen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class NieuweHuisarts {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,plaatsfld,Huisartenfld,Telefoonfld,Websitefld,emailfld;
    @FXML
    private Label ErrorLabel;

    private Context context = Context.getContext();

    public void slaOp() throws IOException {
        System.out.println(isLeeg());
        if(!isLeeg()) {
            context.getHuisartsen().create(getData());
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
        data.add(NaamFld.getText());
        data.add(straatfld.getText());
        data.add(postcodefld.getText());
        data.add(plaatsfld.getText());
        data.add(Huisartenfld.getText());
        data.add(Telefoonfld.getText());
        data.add(Websitefld.getText());
        data.add(emailfld.getText());
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

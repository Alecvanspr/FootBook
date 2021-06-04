package sample.FX.Specialisten;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;
import sample.Database.ContextClasses.Specialisten;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class NieuweSpecialist {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,plaatsfld,ziekenhuisfld,Telefoonfld,emailfld;
    @FXML
    private Label ErrorLabel;
    @FXML
    private ComboBox<String> SpecialiteitComboBox;

    private Context context = Context.getContext();
    private Specialisten specialisten=  context.getSpecialisten();

    public void load(){
        loadComboBox();
    }

    private void loadComboBox(){
        SpecialiteitComboBox.getItems().add("Oncoloog");
        SpecialiteitComboBox.getItems().add("Diabetus verpleger");
        SpecialiteitComboBox.getItems().add("Reumatoloog");
        SpecialiteitComboBox.getItems().add("Hart specialist");
    }
    public void slaOp() throws  IOException
    {
        if(!isLeeg()){
            specialisten.create(getData());
            gaNaarSpecialistenOverzicht();
        }
    }
    private ArrayList<String> getData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(NaamFld.getText());
        arrayList.add(Telefoonfld.getText());
        arrayList.add(straatfld.getText());
        arrayList.add(postcodefld.getText());
        arrayList.add(plaatsfld.getText());
        arrayList.add(emailfld.getText());
        arrayList.add(ziekenhuisfld.getText());
        arrayList.add(SpecialiteitComboBox.getValue());
        return arrayList;
    }
    private Boolean isLeeg(){
        if(isLeeg(NaamFld)&&isLeeg(straatfld)&&isLeeg(postcodefld)&&isLeeg(plaatsfld)&&isLeeg(ziekenhuisfld)&&isLeeg(Telefoonfld))
            return false;
        return true;
    }
    private boolean isLeeg(TextField textField){
        if(textField.getText().equals(""))
            return false;
        return true;
    }

    public void gaNaarSpecialistenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Specialisten/SpecialistenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        SpecialistenOverzicht controller=(SpecialistenOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)NaamFld.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }


}

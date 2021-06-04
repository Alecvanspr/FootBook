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

public class EditSpecialist {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,plaatsfld,ziekenhuisfld,Telefoonfld,emailfld;
    @FXML
    private Label ErrorLabel;
    @FXML
    private ComboBox<String> SpecialiteitComboBox;
    private int id;

    private Context context = Context.getContext();
    private Specialisten specialisten=  context.getSpecialisten();

    public void load(int id){
        loadComboBox();
        setContents(id);
    }
    private void setContents(int id){
        this.id = id;
        NaamFld.setText(specialisten.getList().get(id).naam);
        straatfld.setText(specialisten.getList().get(id).adres);
        postcodefld.setText(specialisten.getList().get(id).postcode);
        plaatsfld.setText(specialisten.getList().get(id).plaats);
        ziekenhuisfld.setText(specialisten.getList().get(id).ziekenhuis);
        Telefoonfld.setText(specialisten.getList().get(id).telefoonnr);
        emailfld.setText(specialisten.getList().get(id).email);
    }
    private void loadComboBox(){
        SpecialiteitComboBox.setValue(specialisten.getList().get(id).specialiteit);
        SpecialiteitComboBox.getItems().add("Oncoloog");
        SpecialiteitComboBox.getItems().add("Diabetus verpleger");
        SpecialiteitComboBox.getItems().add("Reumatoloog");
        SpecialiteitComboBox.getItems().add("Hart specialist");
    }
    public void slaOp() throws  IOException
    {
        if(!isLeeg()){
            specialisten.editSpecialist(getData());
            gaNaarSpecialistenOverzicht();
        }
    }
    private ArrayList<String> getData(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(specialisten.getList().get(id).id);
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

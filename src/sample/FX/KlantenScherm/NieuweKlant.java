package sample.FX.KlantenScherm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.modals.Huisarts;
import sample.modals.Specialist;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class NieuweKlant {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,regnrfld,datumfld,telNrfld,plaatsfld,emailfld,SoaTF,huisartsTF,Voettypetld,orthAffld,huidconfld,huidAandfld,nagelconfld,nagelAandfld,zoekField;

    @FXML
    private Label HuisartsID,Errorlabel,reumatolooglbl,oncolooglbl,diabetistelbl,oncoloogidlbl,reumatoloogidlbl,diabetistelidbl;

    @FXML
    private AnchorPane KanchorPane,HuisartsField, oncoloogField,diabetistField,reumatoloogField;

    private LinkedList<Huisarts> huisarts = Context.getContext().getHuisartsen().getList();

    @FXML
    private CheckBox diabetisCheckBox,ReumaCB,soaCB,kankerCB,elasKousCB,steunZolCB,confZolCB,OrthSchoenCB,chemoCB,uitzaaiingCB,medicijnenCB;

    private Context context = Context.getContext();

    public void laadVelden(){
        loadSpecialisten("Reumatoloog",reumatoloogField,reumatolooglbl,reumatoloogidlbl);
        loadSpecialisten("diabetiste",diabetistField,diabetistelbl,diabetistelidbl);
        loadSpecialisten("Oncoloog",oncoloogField,oncolooglbl,oncoloogidlbl);
        zoek();
    }

    public void GaTerug() throws IOException {
        URL url = new File("src/sample/FX/KlantenScherm/KlantenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        KlantenOverzicht controller =(KlantenOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void slaKlantOp() throws IOException {
        if(checkBenodigdeVelden()) {
            saveClient();
            GoToScreen("KlantenOverzicht");
        }
    }
    private void zoek(){
        if(!zoekField.getText().equals("")) {
            huisarts = Context.getHuisartsen().getList(zoekField.getText());
            Errorlabel.setVisible(false);
        }else{
            Errorlabel.setVisible(true);
        }
    }

    public void loadHuisartsen(){
        int hoogte = 45;
        zoek();
        HuisartsField.getChildren().clear();
        for(int i = 0;i<huisarts.size();i++){
            Rectangle rectangle = makeBorder(hoogte*i);
            int id = i;
            rectangle.setOnMouseClicked(E->{
                huisartsTF.setText(huisarts.get(id).naam);
                HuisartsID.setText(huisarts.get(id).id);
            });

            Label naam = new Label(huisarts.get(i).naam);
            naam.setLayoutY(hoogte*i);
            naam.setLayoutX(15);


            Label huisartsenpost = new Label(huisarts.get(i).huisartsenpost);
            huisartsenpost.setLayoutY(hoogte*i);
            huisartsenpost.setLayoutX(200);
            HuisartsField.setLayoutY(HuisartsField.getLayoutY()+30);
            HuisartsField.getChildren().addAll(rectangle,naam,huisartsenpost);
        }
    }

    public void loadSpecialisten(String specialiteit,AnchorPane pane,Label naamlabel,Label idLabel){
        int hoogte = 45;
        zoek();
        pane.getChildren().clear();
        LinkedList<Specialist> specialisten = Context.getContext().getSpecialisten().getList(specialiteit);
        for(int i = 0;i<specialisten.size();i++){
            Rectangle rectangle = makeBorder(hoogte*i);
            int id = i;
            rectangle.setOnMouseClicked(E->{
                naamlabel.setText(specialisten.get(id).naam);
                idLabel.setText(specialisten.get(id).id);
            });

            Label naam = new Label(specialisten.get(i).naam);
            naam.setLayoutY(hoogte*i);
            naam.setLayoutX(15);


            Label ziekenhuis = new Label(specialisten.get(i).ziekenhuis);
            ziekenhuis.setLayoutY(hoogte*i);
            ziekenhuis.setLayoutX(200);
            pane.setLayoutY(HuisartsField.getLayoutY()+30);
            pane.getChildren().addAll(rectangle,naam,ziekenhuis);
        }
    }
    private Rectangle makeBorder(int y){
        Rectangle rectangle = new Rectangle(325,40);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setLayoutX(5);
        rectangle.setLayoutY(y);
        return rectangle;
    }
    private ArrayList<String> getData(){
        ArrayList<String> data= new ArrayList<>();
        data.add(NaamFld.getText());
        data.add(telNrfld.getText());
        data.add(straatfld.getText());
        data.add(postcodefld.getText());
        data.add(plaatsfld.getText());
        data.add(emailfld.getText());
        data.add(datumfld.getText());
        data.add(regnrfld.getText());
        data.add(context.getHuisartsen().getList(huisartsTF.getText()).getFirst().id);//Huisarts nr
        data.add(""+diabetisCheckBox.isSelected());//diabetus
        data.add(checkleeg(diabetistelidbl.getText()));//diabetusspecialist
        data.add(""+ReumaCB.isSelected());//reuma
        data.add(checkleeg(reumatoloogidlbl.getText()));//reumatoloog
        data.add(""+kankerCB.isSelected());//kanker
        data.add(checkleeg(oncoloogidlbl.getText()));//oncoloog
        data.add(""+chemoCB.isSelected());//chemos
        data.add(medicijnenCB.isSelected()+"");//medicijnen
        data.add(""+uitzaaiingCB.isSelected());//uitzaaiingen
        data.add(checkleeg("leeg"));//terapiën
        data.add(""+soaCB.isSelected());//soa
        data.add(checkleeg("leeg"));//allergenen
        data.add(""+elasKousCB.isSelected());//kousen
        data.add(checkleeg(Voettypetld.getText()));//voettype
        data.add(checkleeg(orthAffld.getText()));//orthopedische afwijkingen
        data.add(""+steunZolCB.isSelected());//steunzolen
        data.add(""+confZolCB.isSelected());//aangepaste confectiezolen
        data.add(""+OrthSchoenCB.isSelected());//orthopedische schoenen
        data.add(checkleeg(huidconfld.getText()));//huidconditie
        data.add(checkleeg(huidAandfld.getText()));//huisaandoeningen
        data.add(checkleeg(nagelconfld.getText()));//nagelconditie
        data.add(checkleeg(nagelAandfld.getText()));//nagelaandoening
        data.add("-");
        return data;
    }
    public boolean checkBenodigdeVelden(){
        return checkfield(NaamFld)&&checkfield(telNrfld)&&checkfield(straatfld)&&checkfield(postcodefld)&&checkfield(plaatsfld)&&checkfield(emailfld)&&checkfield(regnrfld)&&HuisartsID.getText().equals("");
    }
    private boolean checkfield(TextField textField){
        if(textField.getText().equals(""))
            return false;
            return true;
    }

    public void saveClient(){
            Context context = Context.getContext();
            context.getClients().create(getData());
    }
    public String checkleeg(String text){
        if(text.equals("")||text==null){
            return "geen";
        }
        return text;
    }


    public void makeDiabetisVisable(){
        if(diabetisCheckBox.isSelected()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    public void makeKankerVisable(){
        if(kankerCB.isSelected()){
            KanchorPane.setVisible(true);
        }else{
            KanchorPane.setVisible(false);
        }
    }
    public void makeSoaVisable(){
        if(soaCB.isSelected()){
            SoaTF.setVisible(true);
        }else{
            SoaTF.setVisible(false);
        }
    }
    public void GoToScreen(String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file+".fxml"));
        Stage window = (Stage)NaamFld.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

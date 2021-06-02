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
import sample.Database.DateMaker;
import sample.modals.Client;
import sample.modals.Huisarts;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class EditKlant {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,regnrfld,datumfld,telNrfld,plaatsfld,emailfld,SoaTF,huisartsTF,Voettypetld,orthAffld,huidconfld,huidAandfld,nagelconfld,nagelAandfld,zoekField;

    @FXML
    private Label HuisartsID,Errorlabel;

    @FXML
    private AnchorPane KanchorPane,HuisartsField;

    private LinkedList<Huisarts> huisarts = Context.getContext().getHuisartsen().getHuisartsen();

    @FXML
    private CheckBox diabetisCheckBox,ReumaCB,soaCB,kankerCB,elasKousCB,steunZolCB,confZolCB,OrthSchoenCB,chemoCB,uitzaaiingCB,medicijnenCB;

    private Context context = Context.getContext();
    private int id;

    public void slaKlantOp() throws IOException {
        if(checkBenodigdeVelden()) {
            context.getClients().editClient(getData());
            GaKlantenOverzicht();
        }else{
            Errorlabel.setVisible(true);
        }

    }
    public void load(int id){
        this.id = id;
        NaamFld.setText(context.getClients().getClients().get(id).naam);
        straatfld.setText(context.getClients().getClients().get(id).adres);
        postcodefld.setText(context.getClients().getClients().get(id).postcode);
        regnrfld.setText(context.getClients().getClients().get(id).registratieNummer);
        datumfld.setText(DateMaker.maakDate(context.getClients().getClients().get(id).geboortedatum));
        telNrfld.setText(context.getClients().getClients().get(id).telefoonnr);
        plaatsfld.setText(context.getClients().getClients().get(id).plaats);
        emailfld.setText(context.getClients().getClients().get(id).email);
        SoaTF.setText(context.getClients().getClients().get(id).soa+"");
        huisartsTF.setText(context.getClients().getClients().get(id).huisarts.naam);
        Voettypetld.setText(context.getClients().getClients().get(id).voettype);
        orthAffld.setText(context.getClients().getClients().get(id).orthopedischeAfwijkingen);
        huidconfld.setText(context.getClients().getClients().get(id).huidconditie);
        huidAandfld.setText(context.getClients().getClients().get(id).huidaandoening);
        nagelconfld.setText(context.getClients().getClients().get(id).nagelConditie);
        nagelAandfld.setText(context.getClients().getClients().get(id).nagelAandoening);

        diabetisCheckBox.setSelected(context.getClients().getClients().get(id).diabetes!=null);
        ReumaCB.setSelected(context.getClients().getClients().get(id).reuma!=null);
        soaCB.setSelected(context.getClients().getClients().get(id).soa!=null);
        kankerCB.setSelected(context.getClients().getClients().get(id).kanker);
        elasKousCB.setSelected(context.getClients().getClients().get(id).kousen);
        steunZolCB.setSelected(context.getClients().getClients().get(id).steunzolen);
        confZolCB.setSelected(context.getClients().getClients().get(id).confectieSchoenen);
        OrthSchoenCB.setSelected(context.getClients().getClients().get(id).orthopedischeSchoenen);
        //chemoCB.setSelected(context.getClients().getClients().get(id).chemos);
        //uitzaaiingCB.setSelected(context.getClients().getClients().get(id).uitzaaingen); todo deze zorgen dat ze geen errors geven
    }
    private void zoek(){
        if(zoekField.getText()!=null) {
            huisarts = Context.getHuisartsen().getHuisartsen(zoekField.getText());
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
            Rectangle rectangle = new Rectangle(325,40);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLACK);
            rectangle.setLayoutX(5);
            rectangle.setLayoutY(hoogte*i);
            int id = i;
            rectangle.setOnMouseClicked(E->{
                System.out.println("klik");
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
    private ArrayList<String> getData(){
        ArrayList<String> data= new ArrayList<>();
        data.add(context.getClients().getClients().get(id).id);
        data.add(NaamFld.getText());
        data.add(telNrfld.getText());
        data.add(straatfld.getText());
        data.add(postcodefld.getText());
        data.add(plaatsfld.getText());
        data.add(emailfld.getText());
        data.add(datumfld.getText());
        data.add(regnrfld.getText());
        data.add(context.getHuisartsen().getHuisartsen(huisartsTF.getText()).getFirst().id);//Huisarts nr
        data.add(""+diabetisCheckBox.isSelected());//diabetus
        data.add(checkleeg("leeg"));//diabetusspecialist
        data.add(""+ReumaCB.isSelected());//reuma
        data.add(checkleeg("leeg"));//reumatoloog
        data.add(""+kankerCB.isSelected());//kanker
        data.add(checkleeg("leeg"));//oncoloog
        data.add(""+chemoCB.isSelected());//chemos
        data.add(checkleeg("leeg"));//medicijnen
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
        return checkfield(NaamFld)&&checkfield(telNrfld)&&checkfield(straatfld)&&checkfield(postcodefld)&&checkfield(plaatsfld)&&checkfield(emailfld)&&checkfield(regnrfld)&&(!(HuisartsID.getText().equals("")));
    }
    private boolean checkfield(TextField textField){
        if(textField.getText().equals(""))
            return false;
        return true;
    }
    public String checkleeg(String text){
        try {
            if (text.equals("")) {
                return "geen";
            }
            return text;
        }catch(NullPointerException nullPointerException){
            return "Geen";
        }
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
    public void GaKlantenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/KlantenScherm/KlantenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        KlantenOverzicht controller =(KlantenOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void GoToScreen(String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file+".fxml"));
        Stage window = (Stage)NaamFld.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

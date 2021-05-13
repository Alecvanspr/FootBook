package sample.FX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.Context;

import java.io.IOException;
import java.util.ArrayList;

public class NieuweKlant {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,regnrfld,datumfld,telNrfld,plaatsfld,emailfld,SoaTF,Huisartsfld,Voettypetld,orthAffld,huidconfld,huidAandfld,nagelconfld,nagelAandfld;
    @FXML
    private AnchorPane KanchorPane;

    @FXML
    private CheckBox diabetisCheckBox,ReumaCB,soaCB,kankerCB,elasKousCB,steunZolCB,confZolCB,OrthSchoenCB,chemoCB,uitzaaiingCB,medicijnenCB;

    public void GaTerug() throws IOException {
        GoToScreen("KlantenOverzicht");
    }
    public void slaKlantOp() throws IOException {
        saveClient();
        GoToScreen("KlantenOverzicht");
    }

    public void GoToScreen(String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file+".fxml"));
        Stage window = (Stage)NaamFld.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
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
        data.add("1");//Huisarts nr
        data.add(""+diabetisCheckBox.isSelected());//diabetus
        data.add(checkleeg("leeg"));//diabetusspecialist
        data.add(""+ReumaCB);//reuma
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
        return data;
    }

    public void saveClient(){
        Context context = Context.getContext();
        context.makeNewClient(getData());
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
}

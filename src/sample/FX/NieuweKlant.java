package sample.FX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NieuweKlant {
    @FXML
    private TextField NaamFld,straatfld,postcodefld,regnrfld,datumfld,telNrfld,plaatsfld,emailfld,SoaTF,Huisartsfld,Voettypetld,orthAffld,huidconfld,huidAandfld,nagelconfld,nagelAandfld;
    @FXML
    private AnchorPane KanchorPane;

    @FXML
    private CheckBox diabetisCheckBox,ReumaCB,soaCB,kankerCB,elasKousCB,steunZolCB,confZolCB,OrthSchoenCB;

    public void GaTerug() throws IOException {
        GoToScreen("KlantenOverzicht");
    }

    public void GoToScreen(String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file+".fxml"));
        Stage window = (Stage)NaamFld.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
    }
    public void slaKlantOp(){

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

package sample.FX;


import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.Context;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class KlantenOverzicht implements Initializable {
    private ObservableList<String> list;
    private Context context = Context.getContext();
    @FXML
    private ListView listViewKlanten;
    @FXML
    private Button zoekBtn;
    @FXML
    private TextField zoekField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list = FXCollections.observableArrayList(getKlantNaamArray(""));
        list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("List invalidated");
            }
        });
        listViewKlanten.setItems(list);
    }
    private ArrayList<String> getKlantNaamArray(String naam){
        ArrayList ret = new ArrayList();
        for(int i =0;i<context.getClients().size();i++){
            if(context.getClients().get(i).naam.contains(naam))
                ret.add(context.getClients().get(i).naam);
        }
        return ret;
    }
    @FXML
    private void zoek(){
        //hier moet een zoekmethode in komen
    }
    public void GaNaarHomescreen() throws IOException
    {
        GoToScreen("homePage");
    }
    public void MaakNieuweKlant() throws IOException {
        GoToScreen("NieuweKlant");
    }

    public void GoToScreen(String file) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(file+".fxml"));
        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
    }
}

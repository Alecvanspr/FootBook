package sample.FX.KlantenScherm;


import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Database.Clients;
import sample.Database.Context;
import sample.FX.Huisartsen.HuisartsBewerken;
import sample.modals.Client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

public class KlantenOverzicht {
    private ObservableList<String> list;
    private Context context = Context.getContext();
    private int hoogte = 45;
    @FXML
    private AnchorPane klantenOverzicht;
    @FXML
    private Label naamlbl,straatlbl,postcodelbl,plaatslbl,telefoonlbl,geboortedatumlbl,registratienrlbl;
    @FXML
    private Button zoekBtn, edit,behandelingenBtn;
    @FXML
    private TextField zoekField;

    private LinkedList<Client> clients;

    private void zoek(){
        if(!zoekField.equals(""))
            clients = context.getClients().getClients(zoekField.getText());
        else
            clients = context.getClients().getClients();
    }
    public void load(){
        zoek();
        for(int i =0; i<clients.size();i++){
            Rectangle rectangle = new Rectangle(245,40);
            rectangle.setLayoutY(i*hoogte-7);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLACK);
            int h = i*hoogte;
            Label id = new Label(clients.get(i).id);
            id.setLayoutX(10);
            id.setLayoutY(h);
            Label naam = new Label(clients.get(i).naam);
            naam.setLayoutX(55);
            naam.setLayoutY(h);
            int gebruikerID = i;
            rectangle.onMouseClickedProperty().setValue(E->{
                naamlbl.setText(clients.get(gebruikerID).naam);
                straatlbl.setText(clients.get(gebruikerID).adres);
                postcodelbl.setText(clients.get(gebruikerID).postcode);
                plaatslbl.setText(clients.get(gebruikerID).plaats);
                telefoonlbl.setText(clients.get(gebruikerID).telefoonnr);
                geboortedatumlbl.setText(clients.get(gebruikerID).geboortedatum+"");
                registratienrlbl.setText(clients.get(gebruikerID).registratieNummer);
                edit.setOnAction(Event->{
                    try {
                        goKlantBewerken(gebruikerID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                behandelingenBtn.setOnAction(Event->{
                    try {
                        goBehandelGeschiedenis(gebruikerID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });
            klantenOverzicht.getChildren().addAll(rectangle,id,naam);
        }
    }
    public void goKlantBewerken(int id) throws IOException
    {
        URL url = new File("src/sample/FX/KlantenScherm/EditKlant.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        EditKlant controller =(EditKlant) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void goBehandelGeschiedenis(int id) throws IOException
    {
        URL url = new File("src/sample/FX/KlantenScherm/BehandelingGeschiedenis.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        BehandelingGeschiedenis controller =(BehandelingGeschiedenis) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void GaNaarHomescreen() throws IOException
    {
        GoToScreen("homePage");
    }

    public void MaakNieuweKlant() throws IOException {
        GoToScreen("KlantenScherm/NieuweKlant");
    }

    public void GoToScreen(String file) throws IOException {
        URL url = new File("src/sample/FX/"+file+".fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

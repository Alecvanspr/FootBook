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
import sample.FX.Huisartsen.HuisartsenOverzicht;
import sample.FX.Specialisten.SpecialistenOverzicht;
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
    private Label naamlbl,straatlbl,postcodelbl,plaatslbl,telefoonlbl,geboortedatumlbl,registratienrlbl,huisartslbl,KankerInfo,DiabetisInfo,SoaInfo,ReumaInfo;
    @FXML
    private Button zoekBtn, edit,behandelingenBtn, goViewHuisarts, Reumatoloog,oncoloog,diabetiste;
    @FXML
    private TextField zoekField;

    private LinkedList<Client> clients;

    private int extraInfoHeight;

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
                huisartslbl.setText(clients.get(gebruikerID).huisarts.naam);
                goViewHuisarts.setOnAction(Event->{
                    try {
                        goHuisartsScherm(Context.getHuisartsen().getPlace(clients.get(gebruikerID).huisarts.id));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                //overigeInfo.setText(clients.get(gebruikerID).getInfo());
                extraInfoHeight = 230;
                //dit kan niet kleiner gemaakt worden. ontdanks dat er veel duplicate code in zit.
                if(clients.get(gebruikerID).kanker) {
                    KankerInfo.setVisible(true);
                    KankerInfo.setText(clients.get(gebruikerID).kankerInfo.getInfo());
                    KankerInfo.setLayoutY(extraInfoHeight);
                    makeSpecialistButton(oncoloog, Context.getSpecialisten().getPlace(clients.get(gebruikerID).oncoloog.id)); //Context.getSpecialisten().getPlace(clients.get(gebruikerID).oncoloog.id)
                    extraInfoHeight+=75;
                }else{
                    KankerInfo.setText("");
                    oncoloog.setVisible(false);
                }

                if(clients.get(gebruikerID).diabetes!=null) {
                    DiabetisInfo.setVisible(true);
                    DiabetisInfo.setText(clients.get(gebruikerID).diabetes.getInfo());
                    DiabetisInfo.setLayoutY(extraInfoHeight);
                    makeSpecialistButton(diabetiste,Context.getSpecialisten().getPlace(clients.get(gebruikerID).diatusSpecialist.id));
                    extraInfoHeight+=50;
                }else{
                    DiabetisInfo.setText("");
                    diabetiste.setVisible(false);
                }
                if(clients.get(gebruikerID).reuma!=null) {
                    ReumaInfo.setVisible(true);
                    ReumaInfo.setText(clients.get(gebruikerID).reuma.getInfo());
                    ReumaInfo.setLayoutY(extraInfoHeight);

                    makeSpecialistButton(Reumatoloog,Context.getSpecialisten().getPlace(clients.get(gebruikerID).reumatoloog.id));
                    extraInfoHeight+=50;
                }else{
                    ReumaInfo.setText("");
                    Reumatoloog.setVisible(false);
                }

                if(clients.get(gebruikerID).soa!=null) {
                    SoaInfo.setVisible(true);
                    SoaInfo.setText(clients.get(gebruikerID).soa.getInfo());
                    SoaInfo.setLayoutY(extraInfoHeight);
                    extraInfoHeight+=50;
                }else{
                    SoaInfo.setText("");
                }

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
    private void makeSpecialistButton(Button button,int id){
        button.setText(Context.getSpecialisten().getSpecialisten().get(id).naam);
        button.setVisible(true);
        button.setLayoutY(extraInfoHeight);
        button.setOnAction(E->{
            try {
                goSpecialistScherm(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void goKlantBewerken(int id) throws IOException
    {
        URL url = new File("src/sample/FX/KlantenScherm/EditKlant.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        EditKlant controller =(EditKlant) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1500, 900));
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
    public void goHuisartsScherm(int id) throws IOException
    {
        URL url = new File("src/sample/FX/Huisartsen/HuisartsenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        HuisartsenOverzicht controller =(HuisartsenOverzicht) fxmlLoader.getController();
        controller.loadHuisartsen();
        controller.setFields(id);

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void goSpecialistScherm(int id) throws IOException
    {
        URL url = new File("src/sample/FX/Specialisten/SpecialistenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        SpecialistenOverzicht controller =(SpecialistenOverzicht) fxmlLoader.getController();
        controller.load();
        controller.loadSpecialist(id);

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void GaNaarHomescreen() throws IOException
    {
        GoToScreen("homePage");
    }

    public void MaakNieuweKlant() throws IOException {
        URL url = new File("src/sample/FX/KlantenScherm/NieuweKlant.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        NieuweKlant controller =(NieuweKlant) fxmlLoader.getController();
        controller.laadVelden();

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1500, 900));

    }

    public void GoToScreen(String file) throws IOException {
        URL url = new File("src/sample/FX/"+file+".fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

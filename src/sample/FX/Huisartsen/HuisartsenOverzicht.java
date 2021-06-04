package sample.FX.Huisartsen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;
import sample.modals.Personen.Huisarts;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

public class HuisartsenOverzicht {
    @FXML
    private TextField zoekField;
    @FXML
    private Label naamlbl,straatlbl,plaatslbl,postcodelbl,telefoonlbl,emaillbl,websitelbl,Huisartsenpostlbl;

    @FXML
    private AnchorPane HuisartsField;

    @FXML
    private Button BewerkBtn;

    //knop maken om naar de bewerken te gaan

    private LinkedList<Huisarts> huisarts;
    private Context context = Context.getContext();
    public void zoek(){
        if(!(zoekField.getText().equals(""))) {
            huisarts = Context.getHuisartsen().getList(zoekField.getText());
        }else{
            huisarts = Context.getHuisartsen().getList();
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
                setFields(id);
            });

            Label naam = new Label(huisarts.get(id).naam);
            naam.setLayoutY(hoogte*i);
            naam.setLayoutX(15);

            Label huisartsenpost = new Label(huisarts.get(i).huisartsenpost);
            huisartsenpost.setLayoutY(hoogte*i);
            huisartsenpost.setLayoutX(200);
            HuisartsField.setLayoutY(HuisartsField.getLayoutY()+30);
            HuisartsField.getChildren().addAll(rectangle,naam,huisartsenpost);
        }
    }
    public void setFields(int id){
        naamlbl.setText(huisarts.get(id).naam);
        straatlbl.setText(huisarts.get(id).adres);
        plaatslbl.setText(huisarts.get(id).plaats);
        postcodelbl.setText(huisarts.get(id).postcode);
        telefoonlbl.setText(huisarts.get(id).telefoonnr);
        emaillbl.setText(huisarts.get(id).email);
        websitelbl.setText(huisarts.get(id).website);
        Huisartsenpostlbl.setText(huisarts.get(id).huisartsenpost);
        BewerkBtn.setText("bewerk "+ id);
        BewerkBtn.setOnAction(Event->{
            try {
                goHuisartsBewerken(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void goHuisartsBewerken(int id) throws IOException
    {
        URL url = new File("src/sample/FX/Huisartsen/HuisartsBewerken.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        HuisartsBewerken controller =(HuisartsBewerken) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)naamlbl.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));

    }

    public void goNieuweHuisarts() throws IOException
    {
        GoToScreen("Huisartsen/NieuweHuisarts");
    }
    public void GaNaarHomescreen() throws IOException
    {
        GoToScreen("homePage");
    }

    public void GoToScreen(String file) throws IOException {
        URL url = new File("src/sample/FX/"+file+".fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

package sample.FX.Specialisten;

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
import sample.Database.Context;
import sample.modals.Huisarts;
import sample.modals.Specialist;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

public class SpecialistenOverzicht {
    @FXML
    public TextField zoekField;

    @FXML
    private Button bewerkSpecialist;

    @FXML
    private Label naamlbl,straatlbl,plaatslbl,postcodelbl,telefoonlbl,emaillbl,Ziekenhuisbl,Specialiteitlbl;

    @FXML
    private AnchorPane SpecialistenField, InfoPane;

    private LinkedList<Specialist> specialists;
    private Context context = Context.getContext();

    public void zoek(){
        if(!(zoekField.getText().equals(""))) {
            specialists = Context.getSpecialisten().getSpecialisten(zoekField.getText());
        }else{
            specialists = Context.getSpecialisten().getSpecialisten();
        }
    }

    public void load(){
        int hoogte = 45;
        zoek();
        SpecialistenField.getChildren().clear();
        for(int i = 0;i<specialists.size();i++){
            Rectangle rectangle = new Rectangle(325,40);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLACK);
            rectangle.setLayoutX(5);
            rectangle.setLayoutY(hoogte*i);
            int id = i;
            rectangle.setOnMouseClicked(E->{
                naamlbl.setText(specialists.get(id).naam);
                straatlbl.setText(specialists.get(id).adres);
                plaatslbl.setText(specialists.get(id).plaats);
                postcodelbl.setText(specialists.get(id).postcode);
                telefoonlbl.setText(specialists.get(id).telefoonnr);
                emaillbl.setText(specialists.get(id).email);
                Ziekenhuisbl.setText(specialists.get(id).ziekenhuis);

                Specialiteitlbl.setText(specialists.get(id).specialiteit);
                bewerkSpecialist.setOnAction(Event->{
                    try {
                        GoToEditSpecialist(id);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            });

            Label naam = new Label(specialists.get(i).naam);
            naam.setLayoutY(hoogte*i);
            naam.setLayoutX(15);

            Label huisartsenpost = new Label(specialists.get(i).ziekenhuis);
            huisartsenpost.setLayoutY(hoogte*i);
            huisartsenpost.setLayoutX(200);
            SpecialistenField.setLayoutY(SpecialistenField.getLayoutY()+30);


            SpecialistenField.getChildren().addAll(rectangle,naam,huisartsenpost);
        }
    }
    public void GaNaarNieuweSpecialist() throws IOException {
        GoToScreen("Specialisten/NieuweSpecialist");
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
    public void GoToEditSpecialist(int id) throws IOException {
        URL url = new File("src/sample/FX/Specialisten/EditSpecialist.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        EditSpecialist controller = (EditSpecialist) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)zoekField.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

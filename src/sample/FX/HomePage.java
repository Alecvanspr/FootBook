package sample.FX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.Huisartsen;
import sample.FX.Behandelingen.BehandelingsOverzicht;
import sample.FX.Huisartsen.HuisartsenOverzicht;
import sample.FX.Inevaris.Invetaris;
import sample.FX.KlantenScherm.KlantenOverzicht;
import sample.FX.Specialisten.SpecialistenOverzicht;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HomePage {
    @FXML
    private Button KlantenBtn;

    private Context context = Context.getContext();

    //opzich zit hier veel code duplication in, maar vrijwel zinloos en niet mogelijk om dit kleiner te maken.
    public void gaNaarInvetarisOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Inevaris/Invetaris.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Invetaris controller = (Invetaris) fxmlLoader.getController();
        controller.enterTextMouse();

        Stage window = (Stage)KlantenBtn.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void gaNaarBehandelingsOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Behandelingen/BehandelingsOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        BehandelingsOverzicht controller = (BehandelingsOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)KlantenBtn.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void gaNaarHuisartenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Huisartsen/HuisartsenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        HuisartsenOverzicht controller =(HuisartsenOverzicht) fxmlLoader.getController();
        controller.loadHuisartsen();

        Stage window = (Stage)KlantenBtn.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void gaNaarSpecialistenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Specialisten/SpecialistenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        SpecialistenOverzicht controller =(SpecialistenOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)KlantenBtn.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void gaNaarKlantenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/KlantenScherm/KlantenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        KlantenOverzicht controller =(KlantenOverzicht) fxmlLoader.getController();
        controller.load();

        Stage window = (Stage)KlantenBtn.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

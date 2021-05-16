package sample.FX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.FX.Inevaris.Invetaris;
import sample.FX.KlantenScherm.KlantenOverzicht;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HomePage {
    @FXML
    private Label errorLabel;
    public void gaNaarInvetarisOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Inevaris/Invetaris.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Invetaris controller = (Invetaris) fxmlLoader.getController();
        controller.enterTextMouse();

        Stage window = (Stage)errorLabel.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void gaNaarKlantenOverzicht() throws IOException {
        URL url = new File("src/sample/FX/KlantenScherm/KlantenOverzicht.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        KlantenOverzicht controller =(KlantenOverzicht) fxmlLoader.getController();

        Stage window = (Stage)errorLabel.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void WisselScreen(String scherm) throws IOException
    {
        URL url = new File(scherm).toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Stage window = (Stage)errorLabel.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

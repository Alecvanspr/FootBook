package sample.FX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HomePage {
    @FXML
    private Label errorLabel;


    public void gaNaarKlantenOverzicht() throws IOException {
       WisselScreen("KlantenOverzicht");
    }
    public void WisselScreen(String scherm) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(scherm+".fxml"));
        Stage window = (Stage)errorLabel.getScene().getWindow();
        window.setScene(new Scene(root,800,600));

    }
}

package sample.FX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Controller {
    @FXML
    private TextField TextVeld;
    @FXML
    private Label errorLabel;

    @FXML
    private void CheckGebruiker() throws IOException {
        if(TextVeld.getText().equals("")){
            GaNaarHomescreen();
        }else{
            errorLabel.setVisible(true);
        }
    }
    public void GaNaarHomescreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));

        Stage window = (Stage)errorLabel.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
    }
}

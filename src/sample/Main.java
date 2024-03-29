package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL url = new File("src/sample/FX/homePage.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();


        primaryStage.setTitle("Footbook");
        primaryStage.setScene(new Scene(root, 1080, 900));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.FileReader;
import sample.Database.FileUpdater;
import sample.FX.Huisartsen.HuisartsenOverzicht;
import sample.FX.Inevaris.EditProduct;
import sample.FX.KlantenScherm.KlantenOverzicht;
import sample.FX.Specialisten.SpecialistenOverzicht;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
    public Date maakDate(String datum){
        //Deze maakt de substrings
        System.out.println(datum);
        int day = Integer.parseInt(datum.substring(0,2));
        System.out.println(datum);
        int month = Integer.parseInt(datum.substring(3,5));
        System.out.println(datum);
        int year = Integer.parseInt(datum.substring(6,10));
        System.out.println(datum);
        //Deze maakt de Datum die uiteindelijk gereturned wordt.
        Date date = new GregorianCalendar(year,month-1,day).getTime();
        return date;
    }
}

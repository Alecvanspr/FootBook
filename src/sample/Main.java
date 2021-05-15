package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.FX.Inevaris.EditProduct;

import java.util.Date;
import java.util.GregorianCalendar;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FX/Inevaris/EditProduct.fxml"));
        Parent root = fxmlLoader.load();
        EditProduct controller = (EditProduct) fxmlLoader.getController();
        controller.setProduct(1);
        primaryStage.setTitle("Footbook");
        primaryStage.setScene(new Scene(root, 800, 600));
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

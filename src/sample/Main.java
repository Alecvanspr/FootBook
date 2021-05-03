package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.CreateFile;
import sample.Database.FileUpdater;
import sample.modals.Behandeling;
import sample.modals.BehandelingHistory;
import sample.modals.Client;
import sample.modals.Huisarts;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CreateFile createFile = new CreateFile();
        Context context = Context.getContext();
        FileUpdater fileUpdater = new FileUpdater();
        ArrayList<String> data = new ArrayList<>();
        Date date = new Date();
        data.add(fileUpdater.maakDatum(date)); //dit moet later denk kiesbaar zijn
        data.add("1");
        data.add("Geen opmerkingen");
        Client client = context.getClient("0");
        System.out.println(client.getBehandelingGeschiedenis().size());

    }
    //        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    //        primaryStage.setTitle("Hello World");
    //        primaryStage.setScene(new Scene(root, 300, 275));
    //        primaryStage.show();


    public static void main(String[] args) {
        launch(args);
    }
}

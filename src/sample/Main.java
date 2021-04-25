package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.CreateFile;
import sample.modals.Behandeling;
import sample.modals.BehandelingHistory;
import sample.modals.Client;
import sample.modals.Huisarts;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CreateFile createFile = new CreateFile();
        System.out.println("lol");
        Context context = new Context();
        System.out.println("lol");
        Client eerste = context.getClient("1");
        System.out.println("lol");

    }
    //        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    //        primaryStage.setTitle("Hello World");
    //        primaryStage.setScene(new Scene(root, 300, 275));
    //        primaryStage.show();


    public static void main(String[] args) {
        launch(args);
    }
}

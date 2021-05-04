package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.CreateFile;
import sample.modals.*;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CreateFile createFile = new CreateFile();
        Context context = Context.getContext();
        System.out.println(context.getClient(0+""));

    }
    //        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
    //        primaryStage.setTitle("Hello World");
    //        primaryStage.setScene(new Scene(root, 300, 275));
    //        primaryStage.show();


    public static void main(String[] args) {
        launch(args);
    }
}

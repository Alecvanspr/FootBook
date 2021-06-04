package sample.FX.Behandelingen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;
import sample.modals.Behandelingen.Behandeling;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BehandelingsOverzicht {
    private Context context = Context.getContext();
    private int height = 45;

    @FXML
    private AnchorPane Behandelingenpane;

    public void load() {
        for (int i = 0; i < Context.getBehandelingen().getList().size(); i++) {
            Behandeling behandeling = Context.getBehandelingen().getList().get(i);
            Label id = new Label(behandeling.id);
            id.setLayoutY(height*i);

            Label naam = new Label(behandeling.naam);
            naam.setLayoutX(100);
            naam.setLayoutY(height*i);

            Label omschrijving = new Label(behandeling.omschrijving);
            omschrijving.setLayoutX(270);
            omschrijving.setLayoutY(height*i);

            Label prijs = new Label(behandeling.kosten+"");
            prijs.setLayoutX(770);
            prijs.setLayoutY(height*i);

            Button edit = new Button("edit");
            edit.setLayoutX(900);
            edit.setLayoutY(height*i);
            int finalI = i;
            edit.setOnAction(e->{
                try {
                    editBehandeling(finalI);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            Behandelingenpane.getChildren().addAll(id, naam,omschrijving,prijs,edit);
        }
    }
    public void gaNaarAddBehandeling() throws IOException {
        wisselScreen("src/sample/FX/Behandelingen/AddBehandeling.fxml");
    }
    public void gaNaarHomescreen() throws IOException {
        wisselScreen("src/sample/FX/HomePage.fxml");
    }
    public void editBehandeling(int id) throws IOException{
        URL url = new File("src/sample/FX/Behandelingen/EditBehandeling.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        EditBehandeling controller = (EditBehandeling) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)Behandelingenpane.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }

    public void wisselScreen(String URL) throws IOException {
        URL url = new File(URL).toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Stage window = (Stage)Behandelingenpane.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

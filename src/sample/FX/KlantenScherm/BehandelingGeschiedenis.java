package sample.FX.KlantenScherm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.DateMaker;
import sample.modals.Client;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BehandelingGeschiedenis {
    private Context context;
    private Client client;

    @FXML
    private AnchorPane behandelPane;
    private int height = 45;
    public void load(int id){
        context = Context.getContext();
        client = context.getClients().getClients().get(id);
        loadbehandelingen();
    }
    private void loadbehandelingen(){
        for(int i=0;i<client.getBehandelingGeschiedenis().size();i++){
            Label datum = new Label(DateMaker.maakDate(client.getBehandelingGeschiedenis().get(i).datum));
            datum.setLayoutY(height*i);
            Label typeBehandeling = new Label(client.getBehandelingGeschiedenis().get(i).type.naam);
            typeBehandeling.setLayoutY(height*i);
            typeBehandeling.setLayoutX(220);
            Label opmerkingen = new Label(client.getBehandelingGeschiedenis().get(i).bijzonderheden);
            opmerkingen.setLayoutY(height*i);
            opmerkingen.setLayoutX(460);
            behandelPane.getChildren().addAll(datum,typeBehandeling,opmerkingen);
        }
    }
    public void gaNaarAddBehandelHistory() throws IOException
    {
        GoToScreen("BehandelingHistory");
    }
    public void GaNaarHomescreen() throws IOException
    {
        GoToScreen("homePage");
    }

    private void GoToScreen(String file) throws IOException {
        URL url = new File("src/sample/FX/"+file+".fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Stage window = (Stage)behandelPane.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

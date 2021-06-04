package sample.FX.KlantenScherm;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;
import sample.Database.Managers.FileUpdater;
import sample.modals.Behandelingen.BehandelingHistory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AddBehandelingHistory {
    @FXML
    public ComboBox BehandelingBox;
    @FXML
    public TextField datumVeld;

    @FXML
    public TextArea opmerkingen;

    private Context context;
    private int id;

    public void load(int id){
        this.id = Integer.parseInt(Context.getClients().get(id+"").id);
        context = Context.getContext();
        for(int i = 0; i< context.getBehandelingen().getList().size(); i++){
            BehandelingBox.getItems().add(context.getBehandelingen().getList().get(i).naam);
        }
    }
    public void slaOp() throws IOException {
        FileUpdater fileUpdater = new FileUpdater();
        fileUpdater.addBehandeling(
                context.getClients().getClients().get(id).id //deze arraylist is teout if indext
                ,getData());
        context.getClients().getClients().get(id).behandelList.getBehandelingGeschiedenis().add(new BehandelingHistory(getData()));
        goBehandelHistorY();

    }
    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(datumVeld.getText());
        data.add(Context.getBehandelingen().getID(BehandelingBox.getValue() + "")+"");//dit slaat een nummer op
        data.add(checkLeeg(opmerkingen.getText()));
        return data;
    }
    private String checkLeeg(String inhoud){
        if(inhoud.equals("")){
            return "Geen opmerking";
        }
        return inhoud;
    }

    public void goBehandelHistorY() throws IOException {
        URL url = new File("src/sample/FX/KlantenScherm/BehandelingGeschiedenis.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        BehandelingGeschiedenis controller = (BehandelingGeschiedenis) fxmlLoader.getController();
        controller.load(id);

        Stage window = (Stage)BehandelingBox.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

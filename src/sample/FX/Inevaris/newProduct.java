package sample.FX.Inevaris;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.UniqueNumber;
import sample.modals.Product;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class newProduct {
    @FXML
    private TextField naamtf,leveranciertf,omschrijvingtf,inkoopprijstf,verkoopprijstf;

    private Context context = Context.getContext();

    public void slaOp() throws IOException {
        context.getProducten().makeNewProduct(getData());
        ArrayList<String> temp = new ArrayList<>();
        temp.add(UniqueNumber.getUniqueNumber("src/db/MaxProducten.txt")+"");
        temp.addAll(getData());
        context.getProducten().getProducten().add(new Product(temp));
        gaNaarInvetarisOverzicht();

    }
    private ArrayList<String> getData(){
       ArrayList<String> ret = new ArrayList<>();
       ret.add(naamtf.getText());
       ret.add(leveranciertf.getText());
       ret.add(omschrijvingtf.getText());
       ret.add(inkoopprijstf.getText());
       ret.add(verkoopprijstf.getText());
       ret.add("-");
       return ret;
    }
    public void gaNaarInvetarisOverzicht() throws IOException {
        URL url = new File("src/sample/FX/Inevaris/Invetaris.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Invetaris controller = (Invetaris) fxmlLoader.getController();
        controller.enterTextMouse();

        Stage window = (Stage)naamtf.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

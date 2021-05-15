package sample.FX.Inevaris;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.modals.Product;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class EditProduct {
    Context context = Context.getContext();
    private Product product;
    @FXML
    private TextField naamfld, leverancierfld,omschrijvingfld,inkoopprijsfld, verkoopprijsfld;

    public void setProduct(int i){
        product = context.getProducten().getProducten().get(i);
        naamfld.setText(product.naam);
        leverancierfld.setText(product.leverancier);
        omschrijvingfld.setText(product.omschrijving);
        inkoopprijsfld.setText(product.inkoopPrijs+"");
        verkoopprijsfld.setText(product.verkoopPrijs+"");
    }
    public void slaOp() throws IOException {
        ArrayList<String> data = new ArrayList<>();
        data.add(product.id);
        data.add(naamfld.getText());
        data.add(leverancierfld.getText());
        data.add(omschrijvingfld.getText());
        data.add(inkoopprijsfld.getText());
        data.add(verkoopprijsfld.getText());
        context.getProducten().editProducten(data);
        WisselScreen();
    }
    public void WisselScreen() throws IOException
    {
        URL url = new File("src/sample/FX/Inevaris/Invetaris.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage window = (Stage)naamfld.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
    }
}

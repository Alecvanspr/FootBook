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
    private TextField naamfld, leverancierfld,omschrijvingfld,inkoopprijsfld, verkoopprijsfld,aantalfld;
    private int id;

    public void setProduct(int i){
        this.id = i;
        product = context.getProducten().getProducten().get(i).product;
        naamfld.setText(product.naam);
        leverancierfld.setText(product.leverancier);
        omschrijvingfld.setText(product.omschrijving);
        inkoopprijsfld.setText(product.inkoopPrijs+"");
        verkoopprijsfld.setText(product.verkoopPrijs+"");
        aantalfld.setText(context.getProducten().getProducten().get(i).aantal+"");
    }

    public void slaOp() throws IOException {
        ArrayList<String> data = new ArrayList<>();
        data.add(product.id);
        data.add(naamfld.getText());
        data.add(leverancierfld.getText());
        data.add(omschrijvingfld.getText());
        data.add(inkoopprijsfld.getText());
        data.add(verkoopprijsfld.getText());
        data.add(aantalfld.getText());
        context.getProducten().editProducten(data,id);
        WisselScreen();
    }

    public void WisselScreen() throws IOException
    {
        URL url = new File("src/sample/FX/Inevaris/Invetaris.fxml").toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();

        Invetaris controller = (Invetaris) fxmlLoader.getController();
        controller.enterTextMouse();

        Stage window = (Stage)naamfld.getScene().getWindow();
        window.setScene(new Scene(root,1080,900));
    }
}

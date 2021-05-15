package sample.FX.Inevaris;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.Context;
import sample.Database.Producten;
import sample.modals.Product;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Invetaris {
    private Context context = Context.getContext();
    private int hoogte = 45;
    private int breedte = 45;
    @FXML
    private AnchorPane ancorPane;

    @FXML
    public Button btnNext;
    int count = 0;

    @FXML
    public void enterTextMouse(){
        LinkedList<Product> producten = context.getProducten().getProducten();
        for(int i =0; i<producten.size();i++){
            int h = i*hoogte;
            Label id = new Label(producten.get(i).id);
            id.setLayoutX(10);
            id.setLayoutY(h);
            Label naam = new Label(producten.get(i).naam);
            naam.setLayoutX(55);
            naam.setLayoutY(h);
            Label omschrijving = new Label(producten.get(i).omschrijving);
            omschrijving.setLayoutX(250);
            omschrijving.setLayoutY(h);
            Label inkPrijs = new Label(producten.get(i).inkoopPrijs+"");
            inkPrijs.setLayoutX(490);
            inkPrijs.setLayoutY(h);
            Label verkPrijs = new Label(producten.get(i).verkoopPrijs+"");
            verkPrijs.setLayoutX(605);
            verkPrijs.setLayoutY(h);
            Button bewerk = new Button("Edit");
            bewerk.setLayoutX(725);
            bewerk.setLayoutY(h);
            int finalI = i;
            bewerk.setOnAction(e->{
                try {
                    editProduct(finalI);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
            ancorPane.getChildren().addAll(id,naam,omschrijving,inkPrijs,verkPrijs,bewerk);
        }
    }
    public void editProduct(int i) throws IOException {
        URL url = new File("src/sample/FX/Inevaris/EditProduct.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();
        EditProduct controller = (EditProduct) fxmlLoader.getController();
        controller.setProduct(i);
        Stage window = (Stage)btnNext.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
    }
    public void WisselScreen(String scherm) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource(scherm));
        Stage window = (Stage)btnNext.getScene().getWindow();
        window.setScene(new Scene(root,800,600));
    }
}

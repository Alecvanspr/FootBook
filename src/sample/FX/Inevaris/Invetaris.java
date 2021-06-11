package sample.FX.Inevaris;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Database.ContextClasses.Context;
import sample.modals.Voorraad;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

public class Invetaris {
    private Context context = Context.getContext();
    private int hoogte = 45;
    @FXML
    private AnchorPane ancorPane;

    @FXML
    public Button btnNext;
    int count = 0;

    @FXML
    public void enterTextMouse(){
        LinkedList<Voorraad> producten = context.getProducten().getProducten();
        for(int i =0; i<producten.size();i++){
            int h = i*hoogte;
            Label id = new Label(producten.get(i).aantal+ "");
            id.setLayoutX(10);
            id.setLayoutY(h);
            Label naam = new Label(producten.get(i).product.naam);
            naam.setLayoutX(55);
            naam.setLayoutY(h);
            Label omschrijving = new Label(producten.get(i).product.omschrijving);
            omschrijving.setLayoutX(250);
            omschrijving.setLayoutY(h);
            Label inkPrijs = new Label(producten.get(i).product.inkoopPrijs+"");
            inkPrijs.setLayoutX(800);
            inkPrijs.setLayoutY(h);
            Label verkPrijs = new Label(producten.get(i).product.verkoopPrijs+"");
            verkPrijs.setLayoutX(900);
            verkPrijs.setLayoutY(h);
            Button bewerk = new Button("Edit");
            bewerk.setLayoutX(1000);
            bewerk.setLayoutY(h);
            int finalI = i; // dit gaf anders een error
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
    public void makeProduct() throws  IOException{
        WisselScreen("src/sample/FX/Inevaris/newProduct.fxml");
    }
    public void editProduct(int i) throws IOException {
        URL url = new File("src/sample/FX/Inevaris/EditProduct.fxml").toURI().toURL();
        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();
        EditProduct controller = (EditProduct) fxmlLoader.getController();
        controller.setProduct(i);
        Stage window = (Stage)ancorPane.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
    public void Homepage() throws IOException {
        WisselScreen("src/sample/FX/homePage.fxml");
    }
    private void WisselScreen(String scherm) throws IOException
    {
        URL url = new File(scherm).toURI().toURL();

        FXMLLoader fxmlLoader = new FXMLLoader(url);
        Parent root = fxmlLoader.load();


        Stage window = (Stage)ancorPane.getScene().getWindow();
        window.setScene(new Scene(root,1080, 900));
    }
}

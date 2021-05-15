package sample.FX.Inevaris;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Database.Context;
import sample.modals.Product;

public class EditProduct {
    Context context = Context.getContext();
    private Product product;
    @FXML
    private TextField naamfld, leverancierfld,omschrijvingfld,inkoopprijsfld, verkoopprijsfld;

    public void setProduct(int i){
        product = context.getProducten().getProducten().get(i);
        naamfld.setText(product.naam);

    }
    public void load(){

    }
}

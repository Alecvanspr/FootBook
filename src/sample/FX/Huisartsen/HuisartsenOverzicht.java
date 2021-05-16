package sample.FX.Huisartsen;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Database.Context;
import sample.modals.Huisarts;

import java.util.LinkedList;

public class HuisartsenOverzicht {
    @FXML
    private TextField zoekField;

    private LinkedList<Huisarts> huisarts;

    private void zoek(){
        if(zoekField.getText()!=null) {
            huisarts = Context.getHuisartsen().getHuisartsen(zoekField.getText());
        }
    }
}

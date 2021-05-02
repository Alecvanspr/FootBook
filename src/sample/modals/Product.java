package sample.modals;

import java.util.ArrayList;

public class Product {
    public String id;
    public String naam;
    public String leverancier;
    public String omschrijving;
    public Double inkoopPrijs;
    public Double verkoopPrijs;

    public Product(ArrayList<String> data){
        this.id = data.get(0);
        this.naam = data.get(1);
        this.leverancier = data.get(2);
        this.omschrijving = data.get(3);
        this.inkoopPrijs = Double.parseDouble(data.get(4));
        this.verkoopPrijs = Double.parseDouble(data.get(5));
    }
}

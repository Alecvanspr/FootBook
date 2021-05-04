package sample.FacturenMaker;

import sample.modals.Client;
import sample.modals.Product;

import java.util.ArrayList;

public class PriceMaker {
    private double pricePerKM = 0.19;

    public double Vervoerskosten(Client client){
        if(client.travelDistance()>5)
            return client.travelDistance()*pricePerKM;
        return 0.0;
    }
}

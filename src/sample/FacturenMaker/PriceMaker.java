package sample.FacturenMaker;

import sample.Database.Context;
import sample.modals.Behandeling;
import sample.modals.Client;
import sample.modals.Product;

import java.util.ArrayList;

public class PriceMaker {
    Context context = Context.getContext();
    private double pricePerKM = 0.19;

    public double Vervoerskosten(Client client){
        if(client.travelDistance()>=5.0)
            return client.travelDistance()*pricePerKM;
        return 0.0;
    }
    public double berekenTotaal(Client client, Boolean amnese, String bijverkoopItem,String behandelingId){
        double totaal = 0.0;
        if(amnese){
            totaal = 10;
        }
        if(bijverkoopItem!=null){
            totaal=totaal+ context.getProducten().get(Integer.parseInt(bijverkoopItem)).verkoopPrijs;
        }
        if(behandelingId!=null){
            totaal=totaal+ context.getBehandeling(behandelingId).kosten;
        }
        totaal=totaal+Vervoerskosten(client);
        return totaal;
    }
}

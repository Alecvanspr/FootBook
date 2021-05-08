package sample.FacturenMaker;

import sample.Database.Context;
import sample.modals.Behandeling;
import sample.modals.Client;
import sample.modals.Product;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class PriceMaker {
    private Context context = Context.getContext();
    private double pricePerKM = 0.19;
    private ArrayList<Product> producten = new ArrayList<>();
    private ArrayList<Behandeling> behandelingen = new ArrayList<>();
    private Client client;

    public PriceMaker(Client client){
        this.client = client;
    }
    public void addProduct(String id){
        producten.add(context.getProducten().get(Integer.parseInt(id)));
    }
    public void addBehandeling(String id){
        behandelingen.add(context.getBehandeling(id));
    }

    public double Vervoerskosten(){
        if(client.travelDistance()>=5.0)
            return client.travelDistance()*pricePerKM;
        return 0.0;
    }

    public double berekenTotaal(Boolean amnese, String bijverkoopItem,String typeBehandeling){
        System.out.println(typeBehandeling);
        double totaal = 0.0;
        if(amnese){
            totaal = 10;
        }
        if(bijverkoopItem!=null){
            totaal=totaal+ context.getProducten().get(Integer.parseInt(bijverkoopItem)).verkoopPrijs;
        }
        if(typeBehandeling!=null){
            totaal=totaal+ context.getBehandeling(typeBehandeling).kosten;
        }
        totaal=totaal+Vervoerskosten();
        return totaal;
    }
}

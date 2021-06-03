package sample.Database;

import sample.modals.Voorraad;
import sample.modals.Product;

import java.util.ArrayList;
import java.util.LinkedList;

public class Producten implements ContextClass {
    //private static LinkedList<Product> producten;
    private static LinkedList<Voorraad> opslag;
    private static int MaxProducten;

    public Producten(){
        MaxProducten = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxProducten.txt"));
        fillList();
    }
    public void fillList(){
        opslag = new LinkedList<>();
        int pos = 0;
        for(int i = 0; i<=MaxProducten; i++){
            Product product = getFromFile(""+i);
            if(product!=null){
                opslag.addLast(new Voorraad(product,getQuatiteit(pos)));
                pos++;

            }
        }
    }
    private int getQuatiteit(int productId){
        return Integer.parseInt(new FileReader().getFile("producten/quantiteit.txt").get(productId));
    }

    public Product getFromFile(String id) {
        FileReader r = new FileReader();
        if(r.getFile("producten/"+id+".txt")!=null)
            return new Product(r.getFile("producten/"+id+".txt"));
        return null;
    }

    @Override
    public Voorraad get(String id) {
        for(int i = 0;i<opslag.size();i++){
            if(opslag.get(i).product.id.equals(id))
                return opslag.get(i);
        }
        return null;
    }

    public void create(ArrayList<String> data){
        new CreateFile().CreateNewFile("producten",data.toArray());
        addQuantity();
        opslag.add(new Voorraad(new Product(data),0));
    }

    @Override
    public int getPlace(String id) {
        for(int i = 0;i<opslag.size();i++){
            if(opslag.get(i).product.id.equals(id))
                return i;
        }
        return 0;
    }

    private void addQuantity(){
        ArrayList<String> quantiteitData = new FileReader().getFile("producten/quantiteit.txt");
        quantiteitData.add("0");
        new FileUpdater().updateFile("src/db/producten/quantiteit.txt",quantiteitData);
    }

    public void editProducten(ArrayList<String> data,int pos){
        FileUpdater updater = new FileUpdater();
        updateQuantity(pos,data.get(6));
        opslag.get(pos).aantal = Integer.parseInt(data.get(6));
        data.remove(6);
        updater.updateFile("Producten",data);
    }
    private void updateQuantity(int id,String newAantal){
        ArrayList<String> quantiteitData = new FileReader().getFile("producten/quantiteit.txt");
        quantiteitData.set(id,newAantal);
        new FileUpdater().updateFile("src/db/producten/quantiteit.txt",quantiteitData);
    }
    public LinkedList<Voorraad> getProducten(){
        return opslag;
    }
}

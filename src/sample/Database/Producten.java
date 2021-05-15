package sample.Database;

import sample.modals.Product;

import java.util.ArrayList;
import java.util.LinkedList;

public class Producten {
    private static LinkedList<Product> producten;
    private static int MaxProducten;
    private static Producten instance;

    public Producten(){
        FileReader reader = new FileReader();
        MaxProducten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxProducten.txt"));
        fillProducten();
    }
    public static Producten getInstance(){
        if(instance==null){
            instance = new Producten();
        }
        return instance;
    }
    private void fillProducten(){
        producten = new LinkedList<>();
        for(int i = 0; i<=MaxProducten; i++){
            Product product = getProductenFile(""+i);
            if(product!=null){
                producten.addLast(product);
            }
        }
    }
    private Product getProductenFile(String id) {
        FileReader r = new FileReader();
        if(r.getFile("producten/"+id+".txt")!=null)
            return new Product(r.getFile("producten/"+id+".txt"));
        return null;
    }

    public void makeNewProduct(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("producten",data.toArray());
        FileReader fileReader = new FileReader();
        ArrayList<String> quantiteitData = fileReader.getFile("src/db/producten/quantiteit.txt");
        quantiteitData.add("0");
        producten.add(new Product(data));
    }
    public void editProducten(ArrayList<String> data){
        FileUpdater updater = new FileUpdater();
        updater.updateFile("Producten",data);
    }
    public LinkedList<Product> getProducten(){
        return producten;
    }
}

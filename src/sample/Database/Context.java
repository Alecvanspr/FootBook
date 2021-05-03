package sample.Database;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import sample.modals.*;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
//context
//getClient
//getArts
//getSpecialist

public class Context {
    public static Context context;
    public static LinkedList<Client> clients;
    public static LinkedList<Huisarts> Huisartsen;
    public static LinkedList<Specialist> specialisten;
    public static LinkedList<Behandeling> behandelingen;
    public static LinkedList<Product> producten;
    public static int MaxKlanten;
    public static int MaxArtsen;
    public static int MaxSpecialisten;
    public static int MaxBehandelingen;
    public static int MaxProducten;

    //Deze methode maakt haalt alle clients op en plaatst ze in een list.
    public Context(){
        FileReader reader = new FileReader();
        if(MaxKlanten==0){
            //hier worden de Max dingen gevult. Dit is voor alle lists
            MaxKlanten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxKlanten.txt"));
            MaxArtsen = Integer.parseInt(reader.getUniqueNumber("src/db/MaxHuisartsen.txt"));
            MaxSpecialisten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxSpecialisten.txt"));
            MaxBehandelingen = Integer.parseInt(reader.getUniqueNumber("src/db/MaxBehandelingen.txt"));
            MaxProducten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxProducten.txt"));
        }

        if(behandelingen==null) {
            behandelingen = new LinkedList<>();
            for (int i = 0; i < MaxBehandelingen; i++) {
                Behandeling behandeling = getBehandeling("" + i);
                if (behandeling != null) {
                    behandelingen.addLast(behandeling);
                }
            }
        }
        if (Huisartsen==null){
            Huisartsen = new LinkedList<>();
            for(int i = 0; i<=MaxArtsen; i++){
                Huisarts arts =getArtsFile(""+i);
                if(arts!=null) {
                    Huisartsen.addLast(arts);
                }
            }
        }
        if(clients == null){ //Hier wordt vanuit gegaan dat beide leeg zijn.
            clients = new LinkedList<>();

            specialisten = new LinkedList<>();
            producten = new LinkedList<>();
            for(int i = 0; i<=MaxKlanten; i++){
                Client client=getClientFile(""+i);
                if(client!=null) {
                    clients.addLast(client);
                }
            }

            for(int i = 0; i<=MaxSpecialisten; i++){
                Specialist specialist =getSpecialistFile(""+i);
                if(specialist!=null) {
                    specialisten.addLast(specialist);
                }
            }
            for(int i = 0; i<=MaxProducten; i++){
                Product product = getProductenFile(""+i);
                if(product!=null){
                    producten.addLast(product);
                }
            }
        }
    }

    public static Context getContext() {
        if(context==null){
            context = new Context();
        }
        return context;
    }

    private Product getProductenFile(String id) {
        FileReader r = new FileReader();
        if(r.getFile("producten/"+id+".txt")!=null)
            return new Product(r.getFile("producten/"+id+".txt"));
        return null;
    }

    private Client getClientFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("klanten/"+id+"/"+id+".txt")!=null)
        return new Client(r.getFile("klanten/"+id+"/"+id+".txt"));
        return null;
    }
    //hier wordt gesorteerd op het klantId, Dit is een directe zoek
    public Client getClient(String id){
        for(int i = 0; i< clients.size(); i++){
            if(id.equals(clients.get(i).id))
                return clients.get(i);
        }
        return null;
    }

    public LinkedList<Client> getClients(){
        return clients;
    }

    private Huisarts getArtsFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("huisartsen/"+id+"/"+id+".txt")!=null)
        return new Huisarts(r.getFile("huisartsen/"+id+"/"+id+".txt"));
        return null;
    }
    //hier wordt gesorteerd op het arts id
    public Huisarts getArts(String id){
        for(int i = 0; i<Huisartsen.size();i++){
            if(id.equals(Huisartsen.get(i).id))
                return Huisartsen.get(i);
        }
        return null;
    }

    public LinkedList<Huisarts> getHuisartsen() {
        return Huisartsen;
    }

    private Specialist getSpecialistFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("specialisten/"+id+"/"+id+".txt")!=null)
        return new Specialist(r.getFile("specialisten/"+id+"/"+id+".txt"));
        return null;
    }

    //hier wordt gesorteerd op het klantId
    public Specialist getSpecialist(String id){
        for(int i = 0; i<specialisten.size();i++){
            if(id.equals(specialisten.get(i).id))
                return specialisten.get(i);
        }
        return null;
    }


    public LinkedList<Specialist> getSpecialisten() {
        return specialisten;
    }
    private Behandeling getBehandeling(String id){
        FileReader r = new FileReader();
        if(r.getFile("behandelingen/"+id+".txt")!=null)
        return new Behandeling(r.getFile("behandelingen/"+id+".txt"));
        return null;
    }

    public Behandeling findBehandeling (String id){
        for(int i=0;i<behandelingen.size();i++){
            if(behandelingen.get(i).id.equals(id)){
                return behandelingen.get(i);
            }
        }
        return null;
    }
    public LinkedList<Behandeling> getBehandelingen() {
        return behandelingen;
    }

    public void makeNewClient(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("klanten",data.toArray());
        clients.add(new Client(data));
    }
    public void makeNewHuisarts(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("Artsen",data.toArray());
        Huisartsen.add(new Huisarts(data));
    }
    public void makeNewSpecialist(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("Specialisten", data.toArray());
        specialisten.add(new Specialist(data));
    }
    public void makeNewProduct(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("producten",data.toArray());
        producten.add(new Product(data));
    }
    public LinkedList<Product> getProducten(){
        return producten;
    }

}
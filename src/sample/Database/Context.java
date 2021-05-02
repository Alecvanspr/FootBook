package sample.Database;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import sample.modals.*;

import java.util.ArrayList;
import java.util.LinkedList;
//context
//getClient
//getArts
//getSpecialist

public class Context {
    public static LinkedList<Client> clients;
    public static LinkedList<Huisarts> Huisartsen;
    public static LinkedList<Specialist> specialisten;
    public static LinkedList<Behandeling> behandelingen;
    public static LinkedList<Product> producten;
    public static int MaxKlanten;
    public static int MaxArtsen;
    public static int MaxSpecialisten;
    public static int MaxBehandelingen;

    //Deze methode maakt haalt alle clients op en plaatst ze in een list.
    public Context(){
        FileReader reader = new FileReader();
        if(MaxKlanten==0){
            //hier worden de Max dingen gevult. Dit is voor alle lists
            MaxKlanten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxKlanten.txt"));
            MaxArtsen = Integer.parseInt(reader.getUniqueNumber("src/db/MaxArtsen.txt"));
            MaxSpecialisten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxSpecialisten.txt"));
            MaxBehandelingen = Integer.parseInt(reader.getUniqueNumber("src/db/MaxBehandelingen.txt"));
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
        if(clients == null){ //Hier wordt vanuit gegaan dat beide leeg zijn.
            clients = new LinkedList<>();
            Huisartsen = new LinkedList<>();
            specialisten = new LinkedList<>();
            for(int i = 0; i<=MaxKlanten; i++){
                Client client=getClientFile(""+i);
                if(client!=null) {
                    clients.addLast(client);
                }
            }
            for(int i = 0; i<=MaxArtsen; i++){
                Huisarts arts =getArtsFile(""+i);
                if(arts!=null) {
                    Huisartsen.addLast(arts);
                }
            }
            for(int i = 0; i<=MaxSpecialisten; i++){
                Specialist specialist =getSpecialistFile(""+i);
                if(specialist!=null) {
                    specialisten.addLast(specialist);
                }
            }
        }
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
        return new Specialist(r.getFile("specialisten/"+id+"/"+id+".txt"));
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
}

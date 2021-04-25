package sample.Database;

import sample.modals.*;

import java.util.ArrayList;
import java.util.LinkedList;
//context
//getClient
//getArts
//getSpecialist

public class Context {
    public static LinkedList<Client> patienten;
    public static LinkedList<Huisarts> Huisartsen;
    public static LinkedList<Specialist> specialisten;
    public static LinkedList<Behandeling> behandelingen;
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
        if(patienten == null){ //Hier wordt vanuit gegaan dat beide leeg zijn.
            patienten = new LinkedList<>();
            Huisartsen = new LinkedList<>();
            specialisten = new LinkedList<>();
            for(int i = 0; i<=MaxKlanten; i++){
                Client client=getClientFile(""+i);
                if(client!=null) {
                    patienten.addLast(client);
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
        return makeClient(r.getFile("klanten/"+id+"/"+id+".txt"));
    }
    //hier wordt gesorteerd op het klantId, Dit is een directe zoek
    public Client getClient(String id){
        for(int i = 0; i< patienten.size(); i++){
            if(id.equals(patienten.get(i).id))
                return patienten.get(i);
        }
        return null;
    }

    private Client makeClient(ArrayList<String> ClientData){
        if(ClientData!=null) {
            Patient client = new Patient(ClientData);
            return client;
        }
        return null;
    }
    public LinkedList<Client> getClients(){
        return patienten;
    }

    private Huisarts getArtsFile(String id){
        FileReader r = new FileReader();
        return makeArts(r.getFile("huisartsen/"+id+"/"+id+".txt"));
    }
    //hier wordt gesorteerd op het arts id
    public Huisarts getArts(String id){
        for(int i = 0; i<Huisartsen.size();i++){
            if(id.equals(Huisartsen.get(i).id))
                return Huisartsen.get(i);
        }
        return null;
    }

    public Huisarts makeArts(ArrayList<String> ArtsData){
        if(ArtsData!=null) {
            Huisarts huisarts = new Huisarts();
            huisarts.id = ArtsData.get(0);
            if(ArtsData.size()>1) {
                huisarts.naam = ArtsData.get(1);
                huisarts.telefoonnr = ArtsData.get(2);
                huisarts.adres = ArtsData.get(3);
                huisarts.postcode = ArtsData.get(4);
                huisarts.plaats = ArtsData.get(5);
                huisarts.email = ArtsData.get(6);
                huisarts.huisartsenpost = ArtsData.get(7);
                huisarts.website = ArtsData.get(8);
            }
            return huisarts;
        }
        return null;
    }

    public LinkedList<Huisarts> getHuisartsen() {
        return Huisartsen;
    }

    private Specialist getSpecialistFile(String id){
        FileReader r = new FileReader();
        return makeSpecialist(r.getFile("specialisten/"+id+"/"+id+".txt"));
    }

    //hier wordt gesorteerd op het klantId
    public Specialist getSpecialist(String id){
        for(int i = 0; i<specialisten.size();i++){
            if(id.equals(specialisten.get(i).id))
                return specialisten.get(i);
        }
        return null;
    }

    private Specialist makeSpecialist(ArrayList<String> data){
        if(data!=null) {
            Specialist specialist = new Specialist();
            specialist.id = data.get(0);
            if(data.size()>1) {
                specialist.naam = data.get(1);
                specialist.telefoonnr = data.get(2);
                specialist.adres = data.get(3);
                specialist.postcode = data.get(4);
                specialist.plaats = data.get(5);
                specialist.email = data.get(6);
                specialist.ziekenhuis = data.get(7);
            }
            return specialist;
        }
        return null;
    }

    public LinkedList<Specialist> getSpecialisten() {
        return specialisten;
    }
    private Behandeling getBehandeling(String id){
        FileReader r = new FileReader();
        return makeBehandeling(r.getFile("behandelingen/"+id+".txt"));
    }
    private Behandeling makeBehandeling(ArrayList<String> data){
        if(data!=null) {
            Behandeling behandeling = new Behandeling();
            behandeling.id = data.get(0);
            if(data.size()>1) {
                behandeling.naam = data.get(1);
                behandeling.omschrijving = data.get(2);
                behandeling.kosten = Double.parseDouble(data.get(3));
            }
            return behandeling;
        }
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

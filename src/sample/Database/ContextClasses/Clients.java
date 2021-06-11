package sample.Database.ContextClasses;

import sample.Database.Managers.MaxFiles;
import sample.modals.Personen.Client;
import sample.modals.Personen.Klant;

import java.util.ArrayList;
import java.util.LinkedList;

public class Clients implements ContextClass {
    private static LinkedList<Client> clients;

    public Clients(){
        fillList();
    }

    public void fillList(){
        clients = new LinkedList<>();
        for(int i = 0; i< getMax().getMaxFiles(); i++){
            Client client= getFromFile(""+i);
            if(client!=null) {
                clients.addLast(client);
            }
        }
    }
    @Override
    public MaxFiles getMax(){
        return new MaxFiles("src/db/MaxKlanten.txt");
    }
    
    public LinkedList<Client> getClients(String filter) {
        LinkedList<Client> matchingClients = new LinkedList<>();
        for (int i = 0; i < clients.size(); i++) {
            if ((clients.get(i).naam.toLowerCase()).contains(filter.toLowerCase()))
                matchingClients.add(clients.get(i));
        }
        return matchingClients;
    }
    //deze methode is verantwoordelijk voor het ophalen van het txt bestand en het veranderen hiervan in een arraylist.
    public Klant getFromFile(String id) {
        if (reader.getFile("klanten/" + id + "/" + id + ".txt") != null)
            return new Klant(reader.getFile("klanten/" + id + "/" + id + ".txt"));
        return null;
    }

    //met deze methode kan je de client opvragen uit de arraylist op id.
    public Client get(String id) {
        for (int i = 0; i < clients.size(); i++) {
            if (id.equals(clients.get(i).id))
                return clients.get(i);
        }
        return null;
    }

    //hier krijg je de lijst met clients
    public LinkedList<Client> getClients() {
        return clients;
    }

    //hiermee wordt een nieuwe client aangemaakt
    public void create(ArrayList<String> data){
        createFile.CreateNewFile("klanten",data.toArray());
        fillList();
    }

    @Override
    public int getPlace(String id) {
        for(int i =0;i<clients.size();i++){
            if(clients.get(i).id.equals(id)){
                return i;
            }
        }
        return 0;
    }

    //hiermee kan je een client bewerken.
    public void editClient(ArrayList<String> data){
        fileUpdater.updateFile("src/db/Klanten/"+data.get(0)+"/"+data.get(0)+".txt",data);
        fillList();
    }
}

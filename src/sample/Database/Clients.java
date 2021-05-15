package sample.Database;

import sample.modals.Client;

import java.util.ArrayList;
import java.util.LinkedList;

public class Clients {
    private static LinkedList<Client> clients;
    private static Clients instance;
    private static int MaxKlanten;

    public Clients(){
        FileReader reader = new FileReader();
        MaxKlanten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxKlanten.txt"));
        fillClients();
    }
    private void fillClients(){
        clients = new LinkedList<>();
        for(int i = 0; i<MaxKlanten; i++){
            Client client=getClientFile(""+i);
            if(client!=null) {
                clients.addLast(client);
            }
        }
    }
    public static Clients getInstance(){
        if(instance==null) {
            instance = new Clients();
        }
        return  instance;
    }

    public ArrayList<Client> searchClients(String name) {
        ArrayList<Client> matchingClients = new ArrayList<Client>();
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).naam.contains(name))
                matchingClients.add(clients.get(i));
        }
        return matchingClients;
    }

    private Client getClientFile(String id) {
        FileReader r = new FileReader();
        if (r.getFile("klanten/" + id + "/" + id + ".txt") != null)
            return new Client(r.getFile("klanten/" + id + "/" + id + ".txt"));
        return null;
    }

    //hier wordt gesorteerd op het klantId
    public Client getClient(String id) {
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

    public void makeNewClient(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("klanten",data.toArray());
        clients.add(new Client(data));
    }
}

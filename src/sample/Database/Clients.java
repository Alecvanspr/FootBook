package sample.Database;

import sample.Database.*;
import sample.modals.Client;
import sample.modals.ClientsExtentions.*;
import sample.modals.Klant;

import java.util.ArrayList;
import java.util.LinkedList;

public class Clients implements ContextClass {
    private static LinkedList<Client> clients;
    private static int MaxKlanten;

    public Clients(){
        MaxKlanten = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxKlanten.txt"));
        fillList();
    }
    public void fillList(){
        clients = new LinkedList<>();
        for(int i = 0; i<MaxKlanten; i++){
            Client client= getFromFile(""+i);
            if(client!=null) {
                clients.addLast(client);
            }
        }
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
        FileReader r = new FileReader();
        if (r.getFile("klanten/" + id + "/" + id + ".txt") != null)
            return new Klant(r.getFile("klanten/" + id + "/" + id + ".txt"));
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
        CreateFile createFile = new CreateFile();
        createFile.CreateNewFile("klanten",data.toArray());
        clients.add(new Klant(data));
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
        FileUpdater fileUpdater = new FileUpdater();
        fileUpdater.updateFile("src/db/Klanten/"+data.get(0)+"/"+data.get(0)+".txt",data);
        changeClient(data);
    }
    //met deze method wordt de client aangepast en alle gegevens ook.
    private void changeClient(ArrayList<String> data){
        for(int i=0;i<clients.size();i++){
            if(clients.get(i).id.equals(data.get(0))){
                Context context = Context.getContext();
                clients.get(i).naam = data.get(1);
                clients.get(i).telefoonnr = data.get(2);
                clients.get(i).adres = data.get(3);
                clients.get(i).postcode = data.get(4);
                clients.get(i).plaats = data.get(5);
                clients.get(i).email = data.get(6);
                clients.get(i).geboortedatum = DateMaker.maakDate(data.get(7));
                clients.get(i).registratieNummer = data.get(8);
                clients.get(i).huisarts = context.getHuisartsen().get(data.get(9));
                if(Boolean.parseBoolean(data.get(10))){
                    clients.get(i).diabetes = new DiabetisInfo();
                    clients.get(i).diatusSpecialist = context.getSpecialisten().get(data.get(11));
                }
                if(Boolean.parseBoolean(data.get(12))){
                    clients.get(i).reuma = new ReumaInfo();
                    clients.get(i).reumatoloog = context.getSpecialisten().get(data.get(13));
                }
                clients.get(i).kanker = Boolean.parseBoolean(data.get(14));
                if(clients.get(i).kanker) {
                    clients.get(i).kankerInfo = new KankerInfo(SubStringMaker.sub(16,19,data));
                    clients.get(i).oncoloog = context.getSpecialisten().get(data.get(15));
                }
                if(Boolean.parseBoolean(data.get(20))){
                    clients.get(i).soa = new SoaInfo(data.get(21));
                }
                clients.get(i).allergenen = new AllergieInfo(data.get(22));
                if(Boolean.getBoolean(data.get(23))||Boolean.parseBoolean(data.get(26))){
                    clients.get(i).steun = new SteunInfo(Boolean.parseBoolean(data.get(23)),data.get(25),Boolean.parseBoolean(data.get(26)));
                }
                clients.get(i).voet.voettype = data.get(24);
                if(Boolean.parseBoolean(data.get(27))||Boolean.parseBoolean(data.get(28))){
                    clients.get(i).schoen = new SchoenInfo(Boolean.getBoolean(data.get(27)), Boolean.getBoolean(data.get(28)));
                }
                if(!(data.get(29).equals(""))||!(data.get(30).equals(""))){
                    clients.get(i).huid = new HuidInfo(data.get(29),data.get(30));
                }
                if(!data.get(31).equals(""))
                    clients.get(i).nagel = new NagelInfo(data.get(31),data.get(32));
            }
        }
    }
}

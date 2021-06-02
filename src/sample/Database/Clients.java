package sample.Database;

import sample.modals.Client;
import sample.modals.ClientsExtentions.DiabetisInfo;
import sample.modals.ClientsExtentions.KankerInfo;
import sample.modals.ClientsExtentions.ReumaInfo;
import sample.modals.ClientsExtentions.SoaInfo;
import sample.modals.Klant;

import java.util.ArrayList;
import java.util.LinkedList;

public class Clients {
    private static LinkedList<Client> clients;
    private static int MaxKlanten;

    public Clients(){
        MaxKlanten = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxKlanten.txt"));
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

    public LinkedList<Client> getClients(String filter) {
        LinkedList<Client> matchingClients = new LinkedList<>();
        for (int i = 0; i < clients.size(); i++) {
            if ((clients.get(i).naam.toLowerCase()).contains(filter.toLowerCase()))
                matchingClients.add(clients.get(i));
        }
        return matchingClients;
    }
    //deze methode is verantwoordelijk voor het ophalen van het txt bestand en het veranderen hiervan in een arraylist.
    private Klant getClientFile(String id) {
        FileReader r = new FileReader();
        if (r.getFile("klanten/" + id + "/" + id + ".txt") != null)
            return new Klant(r.getFile("klanten/" + id + "/" + id + ".txt"));
        return null;
    }

    //met deze methode kan je de client opvragen uit de arraylist op id.
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

    //hiermee wordt een nieuwe client aangemaakt
    public void makeNewClient(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("klanten",data.toArray());
        clients.add(new Klant(data));
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
                clients.get(i).huisarts = context.getHuisartsen().getArts(data.get(9));
                if(Boolean.parseBoolean(data.get(10))){
                    clients.get(i).diabetes = new DiabetisInfo();
                    clients.get(i).diatusSpecialist = context.getSpecialisten().getSpecialist(data.get(11));
                }
                if(Boolean.parseBoolean(data.get(12))){
                    clients.get(i).reuma = new ReumaInfo();
                    clients.get(i).reumatoloog = context.getSpecialisten().getSpecialist(data.get(13));
                }
                clients.get(i).kanker = Boolean.parseBoolean(data.get(14));
                if(clients.get(i).kanker) {
                    clients.get(i).kankerInfo = new KankerInfo(getKankerInfo(i,data));
                    clients.get(i).oncoloog = context.getSpecialisten().getSpecialist(data.get(15));
                }
                if(Boolean.parseBoolean(data.get(20))){
                    clients.get(i).soa = new SoaInfo(data.get(21));
                }
                clients.get(i).allergenen = data.get(22);
                clients.get(i).kousen = Boolean.getBoolean(data.get(23));
                clients.get(i).voettype = data.get(24);
                clients.get(i).orthopedischeAfwijkingen = data.get(25);
                clients.get(i).steunzolen = Boolean.getBoolean(data.get(26));
                clients.get(i).confectieSchoenen = Boolean.getBoolean(data.get(27));
                clients.get(i).orthopedischeSchoenen = Boolean.getBoolean(data.get(28));
                clients.get(i).huidconditie = data.get(29);
                clients.get(i).huidaandoening = data.get(30);
                clients.get(i).nagelConditie = data.get(31);
                //this.nagelAandoening = data.get(32);
            }
        }
    }

    private ArrayList<String> getKankerInfo(int id,ArrayList<String> data){
        ArrayList<String> ret = new ArrayList<>();
        ret.add(Boolean.parseBoolean(data.get(16))+"");
        ret.add(data.get(17));
        ret.add(Boolean.parseBoolean(data.get(18))+"");
        ret.add(data.get(19)+"");
        return ret;
    }
}

package sample.Database;

import org.junit.Assert;
import sample.modals.Client;
import sample.modals.Huisarts;
import sample.modals.Specialist;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class ContextTest {
    //hiermee wordt de database opgeroepen en kan je met de huidige database testen
    public Context context = Context.getContext();
    public FileReader r = new FileReader();
    public CreateFile c = new CreateFile();
    @org.junit.Test
    public void getClient() {
        Client client = context.getClient(0+"");
        Assert.assertTrue(client.naam.equals("Klaas van der Gouw"));
    }

    @org.junit.Test
    public void getClients() {
    }

    @org.junit.Test
    public void getArts() {
        Huisarts huisarts = Context.getContext().getArts("1");
        Assert.assertTrue(huisarts.id.equals("1"));
    }

    @org.junit.Test
    public void makeArts() {
    }

    @org.junit.Test
    public void getHuisartsen() {
        Assert.assertTrue(context.getHuisartsen()!=null);
    }

    @org.junit.Test
    public void getSpecialist() {
        Specialist specialist = context.getSpecialist("1");
    }

    @org.junit.Test
    public void getSpecialisten() {
        Assert.assertTrue(context.getSpecialisten()!=null);
    }
    @org.junit.Test
    public void addBehandeling(){
        String clientId = r.getUniqueNumber("src/db/MaxBehandeling.txt");
        ArrayList<String> data = new ArrayList<>();
        data.add("Voetmassage Deluxe");
        data.add("test");
        data.add("25.00");
        context.makeBehandeling(data);
        Assert.assertTrue(context.getBehandeling(clientId+"").naam.equals("Voetmassage Deluxe"));
        Assert.assertTrue(context.getBehandeling(clientId+"").omschrijving.equals("test"));
        Assert.assertTrue(context.getBehandeling(clientId+"").kosten==(25.00));
    }

    @org.junit.Test
    public void getBehandeling() {
        Assert.assertTrue(context.getBehandeling("1").id.equals("1"));
    }

    @org.junit.Test
    public void getBehandelingen() {
        Assert.assertTrue(context.getBehandelingen()!=null);
    }
    @org.junit.Test
    public void addClient(){
        ArrayList<String> data = new ArrayList<>();
        data.add(null);
        data.add("Hendrik Pechvogel");//naam
        data.add("06-68780269");//telefoonnr
        data.add("Lange Werpstraat");//straat
        data.add("2382 TP");//postcode
        data.add("Naaldwijk");//plaats
        data.add("HVogel@gmail.com");//emailAdress
        data.add("06-04-1948");//geboorte Datum
        data.add("014");//Registratie nummer
        data.add("2");//Huisarts nr
        data.add("false");//diabetus
        data.add("null");//diabetusspecialist
        data.add("True");//reuma
        data.add("null");//reumatoloog
        data.add("True");//kanker
        data.add("2");//oncoloog
        data.add("true");//chemos
        data.add("null");//medicijnen
        data.add("true");//uitzaaiingen
        data.add("geen");//terapiën
        data.add("false");//soa
        data.add("Lactose");//allergenen
        data.add("false");//kousen
        data.add("Normale voet");//voettype
        data.add("Geen");//orthopedische afwijkingen
        data.add("false");//steunzolen
        data.add("false");//aangepaste confectiezolen
        data.add("false");//orthopedische schoenen
        data.add("Normaal");//huidconditie
        data.add("Geen");//huisaandoeningen
        data.add("Verzorgd");//nagelconditie
        data.add("Geen");//nagelaandoening
        data.add("-");
        context.makeNewClient(data);
        String clientId = r.getUniqueNumber("src/db/MaxKlanten.txt");
        Assert.assertTrue(context.getClient(clientId).naam.equals("Thea van der Meijer"));
        Assert.assertTrue(context.getClient(clientId).postcode.equals("Poeldijk"));
        c.removeFile("src/db/klanten/"+clientId+"/"+clientId+".txt");
    }
    @org.junit.Test
    public void SearchByNameTest(){
        ArrayList<Client> clients = context.searchClients("Marlies");
        Assert.assertTrue(clients.get(0).naam.contains("Marlies"));
    }
}
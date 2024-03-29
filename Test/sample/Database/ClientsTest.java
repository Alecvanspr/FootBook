package sample.Database;

import org.junit.Assert;
import sample.Database.ContextClasses.Context;
import sample.Database.ContextClasses.CreateFile;
import sample.Database.Managers.DeleteFile;
import sample.Database.Managers.UniqueNumber;
import sample.modals.Personen.Client;

import java.util.ArrayList;
import java.util.LinkedList;

public class ClientsTest {
    public Context context = Context.getContext();
    public CreateFile c = new CreateFile();
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
        data.add("-");//diabetusspecialist
        data.add("True");//reuma
        data.add("1");//reumatoloog
        data.add("True");//kanker
        data.add("2");//oncoloog
        data.add("true");//chemos
        data.add("-");//medicijnen
        data.add("true");//uitzaaiingen
        data.add("-");//terapiën
        data.add("false");//soa
        data.add("Lactose");//allergenen
        data.add("false");//kousen
        data.add("Normale voet");//voettype
        data.add("-");//orthopedische afwijkingen
        data.add("false");//steunzolen
        data.add("false");//aangepaste confectiezolen
        data.add("false");//orthopedische schoenen
        data.add("Normaal");//huidconditie
        data.add("-");//huisaandoeningen
        data.add("Verzorgd");//nagelconditie
        data.add("-");//nagelaandoening
        data.add("-");
        context.clients.create(data);
        String clientId = UniqueNumber.getUniqueNumber("src/db/MaxKlanten.txt");
        Assert.assertTrue(context.clients.get(clientId).naam.equals("Thea van der Meijer"));
        Assert.assertTrue(context.clients.get(clientId).postcode.equals("Poeldijk"));
        new DeleteFile().removeFile("src/db/klanten/"+clientId+"/"+clientId+".txt");
    }
    @org.junit.Test
    public void SearchByNameTest(){
        LinkedList<Client> clients = context.clients.getClients("Marlies");
        Assert.assertTrue(clients.get(0).naam.contains("Marlies"));
    }
}

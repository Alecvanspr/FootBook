package sample.Database;

import org.junit.Assert;
import sample.Database.ContextClasses.Context;
import sample.Database.ContextClasses.CreateFile;
import sample.Database.Managers.FileReader;
import sample.modals.Personen.Client;
import sample.modals.Personen.Huisarts;
import sample.modals.Personen.Specialist;

public class ContextTest {
    //hiermee wordt de database opgeroepen en kan je met de huidige database testen
    public Context context = Context.getContext();
    public FileReader r = new FileReader();
    public CreateFile c = new CreateFile();
    @org.junit.Test
    public void getClient() {
        Client client = context.getClients().get(0+"");
        Assert.assertTrue(client.naam.equals("Klaas van der Gouw"));
    }

    @org.junit.Test
    public void getClients() {
    }

    @org.junit.Test
    public void getArts() {
        Huisarts huisarts = Context.getContext().getHuisartsen().get("1");
        Assert.assertTrue(huisarts.id.equals("1"));
    }

    @org.junit.Test
    public void makeArts() {
    }

    @org.junit.Test
    public void getHuisartsen() {
        Assert.assertTrue(context.getHuisartsen().getList()!=null);
    }

    @org.junit.Test
    public void getSpecialist() {
        Specialist specialist = context.getSpecialisten().get("1");
    }

    @org.junit.Test
    public void getSpecialisten() {
        Assert.assertTrue(context.getSpecialisten().getList()!=null);
    }

    @org.junit.Test
    public void getBehandeling() {
        Assert.assertTrue(context.getBehandelingen().get("1").id.equals("1"));
    }

    @org.junit.Test
    public void getBehandelingen() {
        Assert.assertTrue(context.getBehandelingen()!=null);
    }

}
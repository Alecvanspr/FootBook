package sample.Database;

import org.junit.Assert;
import sample.modals.Client;
import sample.modals.Huisarts;
import sample.modals.Specialist;

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
        Huisarts huisarts = Context.getContext().getHuisartsen().getArts("1");
        Assert.assertTrue(huisarts.id.equals("1"));
    }

    @org.junit.Test
    public void makeArts() {
    }

    @org.junit.Test
    public void getHuisartsen() {
        Assert.assertTrue(context.getHuisartsen().getHuisartsen()!=null);
    }

    @org.junit.Test
    public void getSpecialist() {
        Specialist specialist = context.getSpecialisten().getSpecialist("1");
    }

    @org.junit.Test
    public void getSpecialisten() {
        Assert.assertTrue(context.getSpecialisten().getSpecialisten()!=null);
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
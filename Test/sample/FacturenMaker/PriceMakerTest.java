package sample.FacturenMaker;

import org.junit.Assert;
import sample.Database.ContextClasses.Context;
import sample.modals.Personen.Client;

public class PriceMakerTest {
    public Context context = Context.getContext();
    @org.junit.Test
    public void VervoersKostenTest(){
        Client Kwintsheul = context.getClients().get("0"); //0KM
        Client Honserlersdijk = context.getClients().get("5"); //1KM
        Client Poeldijk = context.getClients().get("1"); //4.9KM
        Client Naaldwijk = context.getClients().get("4");//5KM
        Client DenHaag = context.getClients().get("2"); //8.8KM
        Client Gouda = context.getClients().get("6"); //45KM

        PriceMaker kwintsheul = new PriceMaker(Kwintsheul);
        PriceMaker honsel = new PriceMaker(Honserlersdijk);
        PriceMaker poeldijk = new PriceMaker(Poeldijk);
        PriceMaker naaldwijk = new PriceMaker(Naaldwijk);
        PriceMaker denhaag = new PriceMaker(DenHaag);
        PriceMaker gouda = new PriceMaker(Gouda);

        Assert.assertEquals(0,kwintsheul.Vervoerskosten(),0.1);
        Assert.assertEquals(0,honsel.Vervoerskosten(),0.1);
        Assert.assertEquals(0,poeldijk.Vervoerskosten(),0.1);
        Assert.assertEquals(0.95,naaldwijk.Vervoerskosten(),0.2);
        Assert.assertEquals(1.67,denhaag.Vervoerskosten(),0.2);
        Assert.assertEquals(8.55,gouda.Vervoerskosten(),0.2);
    }
    @org.junit.Test
    public void berekenTotaalTest(){
        Client kwintsheul = context.getClients().get("0"); //0KM
        Client naaldwijk = context.getClients().get("4");//5KM
        PriceMaker Kwintsheul = new PriceMaker(kwintsheul);
        PriceMaker Naaldwijk = new PriceMaker(naaldwijk);

        Assert.assertEquals(49.00,Kwintsheul.berekenTotaal(true,"0","1"),0.2);
        Assert.assertEquals(0.00,Kwintsheul.berekenTotaal(false,null,null),0.2);
        Assert.assertEquals(44.00,Kwintsheul.berekenTotaal(true,null,"1"),0.2);
        Assert.assertEquals(39.00,Kwintsheul.berekenTotaal(false,"0","1"),0.2);

        Assert.assertEquals(10.95,Naaldwijk.berekenTotaal(true,null,null),0.2);
        Assert.assertEquals(5.95,Naaldwijk.berekenTotaal(false,"0",null),0.2);
        Assert.assertEquals(15.95,Naaldwijk.berekenTotaal(true,"0",null),0.2);
        Assert.assertEquals(34.95,Naaldwijk.berekenTotaal(false,null,"1"),0.2);
    }
}

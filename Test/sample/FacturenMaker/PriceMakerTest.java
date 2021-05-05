package sample.FacturenMaker;

import org.junit.Assert;
import sample.Database.Context;
import sample.modals.Client;

public class PriceMakerTest {
    public Context context = Context.getContext();
    public PriceMaker priceMaker = new PriceMaker();
    @org.junit.Test
    public void VervoersKostenTest(){
        Client kwintsheul = context.getClient("0"); //0KM
        Client Honserlersdijk = context.getClient("5"); //1KM
        Client Poeldijk = context.getClient("1"); //4.9KM
        Client Naaldwijk = context.getClient("4");//5KM
        Client DenHaag = context.getClient("2"); //8.8KM
        Client Gouda = context.getClient("6"); //45KM

        Assert.assertEquals(0,priceMaker.Vervoerskosten(kwintsheul),0.1);
        Assert.assertEquals(0,priceMaker.Vervoerskosten(Honserlersdijk),0.1);
        Assert.assertEquals(0,priceMaker.Vervoerskosten(Poeldijk),0.1);
        Assert.assertEquals(0.95,priceMaker.Vervoerskosten(Naaldwijk),0.2);
        Assert.assertEquals(1.67,priceMaker.Vervoerskosten(DenHaag),0.2);
        Assert.assertEquals(8.55,priceMaker.Vervoerskosten(Gouda),0.2);
    }
    @org.junit.Test
    public void berekenTotaalTest(){
        Client kwintsheul = context.getClient("0"); //0KM
        Client Naaldwijk = context.getClient("4");//5KM

        Assert.assertEquals(49.00,priceMaker.berekenTotaal(kwintsheul,true,"0","1"),0.2);
        Assert.assertEquals(0.00,priceMaker.berekenTotaal(kwintsheul,false,null,null),0.2);
        Assert.assertEquals(44.00,priceMaker.berekenTotaal(kwintsheul,true,null,"1"),0.2);
        Assert.assertEquals(39.00,priceMaker.berekenTotaal(kwintsheul,false,"0","1"),0.2);

        Assert.assertEquals(10.95,priceMaker.berekenTotaal(Naaldwijk,true,null,null),0.2);
        Assert.assertEquals(5.95,priceMaker.berekenTotaal(Naaldwijk,false,"0",null),0.2);
        Assert.assertEquals(15.95,priceMaker.berekenTotaal(Naaldwijk,true,"0",null),0.2);
        Assert.assertEquals(34.95,priceMaker.berekenTotaal(Naaldwijk,false,null,"1"),0.2);
    }
}

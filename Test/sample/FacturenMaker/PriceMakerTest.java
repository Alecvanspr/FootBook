package sample.FacturenMaker;

import org.junit.Assert;
import sample.Database.Context;
import sample.modals.Client;

public class PriceMakerTest {
    public Context context = Context.getContext();

    @org.junit.Test
    public void VervoersKostenTest(){
        PriceMaker priceMaker = new PriceMaker();
        Client kwintsheul = context.getClient("0"); //0KM
        Client Honserlersdijk = context.getClient("5"); //1KM
        Client Poeldijk = context.getClient("1"); //4.9KM
        Client DenHaag = context.getClient("2"); //8.8KM
        Client Gouda = context.getClient("6"); //45KM
        Assert.assertEquals(0,priceMaker.Vervoerskosten(kwintsheul),0.1);
        Assert.assertEquals(0,priceMaker.Vervoerskosten(Honserlersdijk),0.1);
        Assert.assertEquals(0,priceMaker.Vervoerskosten(Poeldijk),0.1);
        Assert.assertEquals(1.7,priceMaker.Vervoerskosten(DenHaag),0.1);
        Assert.assertEquals(8.55,priceMaker.Vervoerskosten(Gouda),0.1);
    }
}

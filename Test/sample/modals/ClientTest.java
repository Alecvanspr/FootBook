package sample.modals;

import org.junit.Assert;
import sample.Database.Context;
import sample.modals.Client;
import sample.modals.Huisarts;
import sample.modals.Specialist;

import java.util.*;

import static org.junit.Assert.*;

public class ClientTest {
    public Context context= Context.getContext();

    @org.junit.Test
    public void testContext(){
        System.out.println(context.getClient("1"));
    }
    @org.junit.Test
    public void testCreateClient(){

    }

    @org.junit.Test
    public void maakDatum() {
        Date datum = context.maakDate("26-03-2002");
        Date correctDate = new Date(102, 2,26);
        Assert.assertEquals(datum,correctDate);
    }
    @org.junit.Test
    public void getBehandelingen(){
        Client client = context.getClient("1");
        client.addBehandeling("26-03-2021","Test","SideNoteTest");
        client.addBehandeling("27-03-2021","TestGeval","Opmerking");
        client.addBehandeling("08-05-2021","een ander Testgeval","een goede Opmerking");
        Assert.assertTrue(client.getBehandelingGeschiedenis().get(0).type.equals("Test"));
        Assert.assertTrue(client.getBehandelingGeschiedenis().get(1).type.equals("TestGeval"));
        Assert.assertTrue(client.getBehandelingGeschiedenis().get(2).type.equals("een ander Testgeval"));
    }
    @org.junit.Test
    public void getScreenings(){

    }
    @org.junit.Test
    public void allowScreeningTest(){
        Client diabeet = context.getClient("2");
        Client kankerPatient = context.getClient("3");
        Client reumapatient = context.getClient("4");
        Client kankerReumaPatient = context.getClient("6");

        Assert.assertTrue(diabeet.allowScreening());
        Assert.assertFalse(kankerPatient.allowScreening());
        Assert.assertFalse(reumapatient.allowScreening());
        Assert.assertTrue(kankerReumaPatient.allowScreening());
    }
    @org.junit.Test
    public void travelDistanceTest(){
        Client kwintsheul = context.getClient("0");
        Client Honserlersdijk = context.getClient("5");
        Client Poeldijk = context.getClient("1");
        Client DenHaag = context.getClient("2");
        Client Gouda = context.getClient("6");
        Assert.assertEquals(0,kwintsheul.travelDistance(),0.1);
        Assert.assertEquals(1.0,Honserlersdijk.travelDistance(),0.1);
        Assert.assertEquals(4.9,Poeldijk.travelDistance(),0.0);
        Assert.assertEquals(8.8,DenHaag.travelDistance(),0.0);
        Assert.assertEquals(45.0,Gouda.travelDistance(),0.0);
    }
}


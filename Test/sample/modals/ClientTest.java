package sample.modals;

import org.junit.Assert;
import sample.Database.ContextClasses.Context;
import sample.Database.Tools.DateMaker;
import sample.modals.Personen.Client;

import java.util.*;

public class ClientTest {
    public Context context= Context.getContext();

    @org.junit.Test
    public void MaakScreening(){
    }

    @org.junit.Test
    public void maakDatum() {
        Date datum = DateMaker.maakDate("26-03-2002");
        Date correctDate = new Date(102, 2,26);
        Assert.assertEquals(datum,correctDate);
    }
    @org.junit.Test
    public void getBehandelingen(){
        Client client = context.getClients().get("1");
        client.behandelList.addBehandeling("26-03-2021","1","SideNoteTest");
        client.behandelList.addBehandeling("27-03-2021","2","Opmerking");
        client.behandelList.addBehandeling("08-05-2021","3","een goede Opmerking");
        //BehandelingHistory behandelingHistory = new BehandelingHistory();
        //Assert.assertTrue(client.getBehandelingGeschiedenis().get(0).type.equals("Test"));
        //Assert.assertTrue(client.getBehandelingGeschiedenis().get(1).type.equals("TestGeval"));
        //Assert.assertTrue(client.getBehandelingGeschiedenis().get(2).type.equals("een ander Testgeval"));
    }
    @org.junit.Test
    public void allowScreeningTest(){
        Client client = context.getClients().get("1");
        Client diabeet = context.getClients().get("2");
        Client kankerPatient = context.getClients().get("3");
        Client reumapatient = context.getClients().get("4");
        Client kankerReumaPatient = context.getClients().get("6");

        Assert.assertFalse(client.allowScreening());
        Assert.assertTrue(diabeet.allowScreening());
        Assert.assertFalse(kankerPatient.allowScreening());
        Assert.assertFalse(reumapatient.allowScreening());
        Assert.assertTrue(kankerReumaPatient.allowScreening());
    }
    @org.junit.Test
    public void travelDistanceTest(){
        Client kwintsheul = context.getClients().get("0");
        Client Honserlersdijk = context.getClients().get("5");
        Client Poeldijk = context.getClients().get("1");
        Client DenHaag = context.getClients().get("2");
        Client Gouda = context.getClients().get("6");
        Assert.assertEquals(0,kwintsheul.travelDistance(),0.1);
        Assert.assertEquals(1.0,Honserlersdijk.travelDistance(),0.1);
        Assert.assertEquals(4.9,Poeldijk.travelDistance(),0.0);
        Assert.assertEquals(8.8,DenHaag.travelDistance(),0.0);
        Assert.assertEquals(45.0,Gouda.travelDistance(),0.0);
    }
}


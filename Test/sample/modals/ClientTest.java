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
    public Client client = context.getClient("1");

    @org.junit.Test
    public void maakDatum() {
        Date datum = client.maakDate("26-03-2002");
        Date correctDate = new Date(102, 2,26);
        Assert.assertEquals(datum,correctDate);
    }
    @org.junit.Test
    public void getBehandelingen(){
        client.addBehandeling("26-03-2021","Test","SideNoteTest");
        client.addBehandeling("27-03-2021","TestGeval","Opmerking");
        client.addBehandeling("08-05-2021","een ander Testgeval","een goede Opmerking");
        Assert.assertTrue(client.getBehandelingGeschiedenis().get(0).type.equals("Test"));
        Assert.assertTrue(client.getBehandelingGeschiedenis().get(1).type.equals("TestGeval"));
        Assert.assertTrue(client.getBehandelingGeschiedenis().get(2).type.equals("een ander Testgeval"));
    }
}

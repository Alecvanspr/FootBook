package sample.modals;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.Behandelingen.Behandeling;

import java.util.ArrayList;

public class BehandelingTest {
    @Test
    public void TestAanmaken(){
        ArrayList<String> data = new ArrayList<>();
        data.add("43");
        data.add("Luxe voetbehandeling");
        data.add("Een zeer uitgebreide voetmassage");
        data.add("25.55");
        Behandeling behandeling = new Behandeling(data);
        Assert.assertEquals(behandeling.id,"43");
        Assert.assertEquals(behandeling.naam,"Luxe voetbehandeling");
        Assert.assertEquals(behandeling.omschrijving,"Een zeer uitgebreide voetmassage");
        Assert.assertEquals(behandeling.kosten,25.55,1);
    }
}

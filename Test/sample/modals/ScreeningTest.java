package sample.modals;

import org.junit.Assert;
import org.junit.Test;
import sample.Database.Tools.DateMaker;

import java.util.ArrayList;

public class ScreeningTest {
    @Test
    public void testAanmaken() {
        ArrayList<String> data = new ArrayList<>();
        data.add("26-03-2002");
        data.add("True");
        data.add("Geen");
        data.add("Geen opmerking");
        data.add("Lichte gevoelloosheid");
        data.add("Als je hard drukt dan voelt ze niks");
        Screening screening = new Screening(data);
        Assert.assertEquals(DateMaker.maakDate("26-03-2002"),screening.datum);
        Assert.assertTrue(screening.koudeVoeten);
        Assert.assertEquals("Geen",screening.gevoelR);
        Assert.assertEquals("Geen opmerking",screening.opmerkingGevoelR);
        Assert.assertEquals("Lichte gevoelloosheid",screening.gevoelL);
        Assert.assertEquals("Als je hard drukt dan voelt ze niks",screening.opmerkingGevoelL);
    }
}

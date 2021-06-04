package sample.modals;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.Personen.Huisarts;

import java.util.ArrayList;

public class HuisartsTest {
    @Test
    public void testAanmaken(){
        Huisarts huisarts= new Huisarts(getData());
        Assert.assertEquals("023",huisarts.id);
        Assert.assertEquals("Gert de doctor",huisarts.naam);
        Assert.assertEquals("0646665141",huisarts.telefoonnr);
        Assert.assertEquals("Lange Woonwijk 3",huisarts.adres);
        Assert.assertEquals("1234PX",huisarts.postcode);
        Assert.assertEquals("Woerden",huisarts.plaats);
        Assert.assertEquals("GertDoctor@Gmail.com",huisarts.email);
        Assert.assertEquals("LichteKwaal",huisarts.huisartsenpost);
        Assert.assertEquals("lichteKwaal.nl",huisarts.website);
    }
    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<String>();
        data.add("023");
        data.add("Gert de doctor");
        data.add("0646665141");
        data.add("Lange Woonwijk 3");
        data.add("1234PX");
        data.add("Woerden");
        data.add("GertDoctor@Gmail.com");
        data.add("LichteKwaal");
        data.add("lichteKwaal.nl");
        return data;
    }
}

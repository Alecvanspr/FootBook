package sample.Database;

import org.junit.Assert;
import org.junit.Test;
import sample.Database.ContextClasses.Context;
import sample.modals.Personen.Huisarts;

import java.util.ArrayList;

public class HuisartsenTest {
    private Context context = Context.getContext();

    private void load(){
        context.getHuisartsen().getList().add(new Huisarts(getData()));
    }
    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
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
    @Test
    public void testGetArts(){
        load();
        Assert.assertEquals("023",context.getHuisartsen().get("023").id);
        Assert.assertEquals("Gert de doctor",context.getHuisartsen().get("023").naam);
    }
    @Test
    public void testMakeNewHuisarts(){
        //Dit is beter om visueel te testen. anders worden er honderd bestanden aangemaak die allemaal wat toevoegen.
        //context.getHuisartsen().makeNewHuisarts(getData());
        //Assert.assertEquals("023",context.getHuisartsen().getHuisartsen().getLast());

    }
    @Test
    public void testGetHuisartsen(){
        //deze tests kunnen afwijken als er te veel data aan de database wordt toegevoed
        load();
        Assert.assertEquals("023",context.getHuisartsen().getList("023").getFirst().id);
        Assert.assertEquals("023",context.getHuisartsen().getList("Gert de doctor").getFirst().id);
        Assert.assertEquals("023",context.getHuisartsen().getList("LichteKwaal").getFirst().id);

        Assert.assertEquals("Gert de doctor",context.getHuisartsen().getList("23").getFirst().naam);
        Assert.assertEquals("Gert de doctor",context.getHuisartsen().getList("Gert").getFirst().naam);
        Assert.assertEquals("Gert de doctor",context.getHuisartsen().getList("Kwaal").getFirst().naam);
    }
    @Test
    public void testEditHuisarts(){
        //dit is ook een hardcoded test
    }
}

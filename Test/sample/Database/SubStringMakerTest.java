package sample.Database;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SubStringMakerTest {
    @Test
    public void testSubStringMaker(){
        ArrayList<String> data = getData();
        ArrayList<String> TestData = getDataTest();
        Assert.assertEquals(data.get(0),SubStringMaker.sub(0,0,data).get(0));
        Assert.assertEquals(2,SubStringMaker.sub(2,3,data).size());
        Assert.assertEquals(TestData,SubStringMaker.sub(3,6,data));
    }

    private ArrayList<String> getDataTest() {
        ArrayList<String> data = new ArrayList();
        data.add("Mars");
        data.add("Jupiter");
        data.add("Saturnus");
        data.add("Uranus");
        return data;
    }

    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList();
        data.add("Mecurius");
        data.add("Venus");
        data.add("Aarde");
        data.add("Mars");
        data.add("Jupiter");
        data.add("Saturnus");
        data.add("Uranus");
        data.add("Neptunus");
        data.add("Pluto");
        return data;
    }
}

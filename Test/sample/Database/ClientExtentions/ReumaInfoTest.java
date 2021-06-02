package sample.Database.ClientExtentions;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.ClientsExtentions.DiabetisInfo;
import sample.modals.ClientsExtentions.ReumaInfo;

import java.util.ArrayList;

public class ReumaInfoTest {
    @Test
    public void testGetInfo(){
        ReumaInfo waar = new ReumaInfo();
        Assert.assertEquals("Deze klant heeft Reuma", waar.getInfo());
    }
    private ArrayList<String> maakArraylist(String data){
        ArrayList arrayList = new ArrayList();
        arrayList.add(data);
        return arrayList;
    }
}

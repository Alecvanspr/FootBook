package sample.Database.ClientExtentions;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.ClientsExtentions.DiabetisInfo;

import java.util.ArrayList;

public class DiabetisInfoTest {
    @Test
    public void testGetInfo(){
        DiabetisInfo waar = new DiabetisInfo();
        Assert.assertEquals("Deze klant heeft Diabetis", waar.getInfo());
    }
}

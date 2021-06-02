package sample.Database.ClientExtentions;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.ClientsExtentions.SoaInfo;

public class SoaTest {
    @Test
    public void testSoa(){
        SoaInfo soaInfo = new SoaInfo("Test");
        Assert.assertEquals("Deze klant heeft de soa Test",soaInfo.getInfo());
    }
}

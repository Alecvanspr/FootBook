package sample.modals;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ProductTest {
    @Test
    public void TestAanmaken(){
        ArrayList<String> data = new ArrayList<>();
        data.add("23");
        data.add("Koude voeten zalf");
        data.add("Provoet");
        data.add("dit is een zalf tegen koude voeten");
        data.add("5.66");
        data.add("15.00");
        Product product = new Product(data);
        Assert.assertEquals("23",product.id);
        Assert.assertEquals("Koude voeten zalf",product.naam);
        Assert.assertEquals("Provoet",product.leverancier);
        Assert.assertEquals("dit is een zalf tegen koude voeten",product.omschrijving);
        Assert.assertEquals(5.66,product.inkoopPrijs,2);
        Assert.assertEquals(15.00,product.verkoopPrijs,2);
    }
}

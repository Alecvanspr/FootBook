package sample.modals;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SpecialistTest {
    @Test
    public void TestAanmaken() {
        ArrayList<String> data = new ArrayList<>();
        data.add("05");
        data.add("Ben Dover");
        data.add("0646665141");
        data.add("Ziekenhuisstraat");
        data.add("2698PX");
        data.add("Dronten");
        data.add("BenDover@Gmail.com");
        data.add("Zieknhuis");
        data.add("Oncoloog");
        Specialist specialist = new Specialist(data);
        Assert.assertEquals("05",specialist.id);
        Assert.assertEquals("Ben Dover",specialist.naam);
        Assert.assertEquals("0646665141",specialist.telefoonnr);
        Assert.assertEquals("Ziekenhuisstraat",specialist.adres);
        Assert.assertEquals("2698PX",specialist.postcode);
        Assert.assertEquals("Dronten",specialist.plaats);
        Assert.assertEquals("BenDover@Gmail.com",specialist.email);
        Assert.assertEquals("Zieknhuis",specialist.ziekenhuis);
        Assert.assertEquals("Oncoloog",specialist.specialiteit);
    }
}

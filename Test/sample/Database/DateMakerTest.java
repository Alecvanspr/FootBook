package sample.Database;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateMakerTest {
    @Test
    public void maakDate(){
        Date date = new GregorianCalendar(2021,4,29).getTime();
        Assert.assertEquals(date,DateMaker.maakDate("29-05-2021"));
    }
    @Test
    public void maakDateString(){
        Date datum = new GregorianCalendar(2021,4,29).getTime();
        Assert.assertEquals("29-05-2021",DateMaker.maakDate(datum));
        Date date = new GregorianCalendar(2002,2,26).getTime();
        Assert.assertEquals("26-03-2002",DateMaker.maakDate(date));
        Assert.assertEquals("03-03-2002",DateMaker.maakDate(new GregorianCalendar(2002,2,3).getTime()));
    }
}

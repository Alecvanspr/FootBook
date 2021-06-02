package sample.modals;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class BehandelingListTest {
    @Test
    public void fillListTest(){
        BehandelList behandelList = new BehandelList(1+"");
        Assert.assertEquals(behandelList.getBehandelingGeschiedenis().get(0).bijzonderheden,("SideNoteTest"));
        Assert.assertEquals(behandelList.getBehandelingGeschiedenis().get(0).type.id,("2"));
        Date date = new Date(121,2,26);
        Assert.assertEquals(behandelList.getBehandelingGeschiedenis().get(0).datum,date);
    }
}
package sample.Database.ClientExtentions;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.ClientsExtentions.KankerInfo;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class KankerInfoTest {

    @Test
    public void getInfo() {
        //0. heeft niks
        KankerInfo kankerinfo0 = new KankerInfo(getData0(0,0,0,0));
        //1. heeft chemos en terapiën
        KankerInfo kankerinfo1 = new KankerInfo(getData0(0,0,1,1));
        //2. heeft uizaiingen en chemos
        KankerInfo kankerinfo2 = new KankerInfo(getData0(1,0,1,0));
        //3. heeft medicijnen en terapiën
        KankerInfo kankerinfo3 = new KankerInfo(getData0(0,1,0,1));
        //4. heeft uitzaaiingen en medicijnen
        KankerInfo kankerinfo4 = new KankerInfo(getData0(1,1,0,0));
        //5. heeft alles
        KankerInfo kankerinfo5 = new KankerInfo(getData0(1,1,1,1));

        Assert.assertEquals("Deze klant heeft kanker \r\n",kankerinfo0.getInfo());
        Assert.assertEquals("Deze klant heeft kanker \r\n"+"Deze klant krijgt chemos \r\n"+"Deze klant krijgt Terapien \r\n",kankerinfo1.getInfo());
        Assert.assertEquals("Deze klant heeft kanker \r\n"+"Deze klant heeft last van uitzaaingen \r\n"+"Deze klant krijgt chemos \r\n",kankerinfo2.getInfo());
        Assert.assertEquals("Deze klant heeft kanker \r\n"+"Deze klant gebruikt medicijnen \r\n"+"Deze klant krijgt Terapien \r\n",kankerinfo3.getInfo());
        Assert.assertEquals("Deze klant heeft kanker \r\n"+"Deze klant heeft last van uitzaaingen \r\n"+"Deze klant gebruikt medicijnen \r\n",kankerinfo4.getInfo());
        Assert.assertEquals("Deze klant heeft kanker \r\n"+"Deze klant heeft last van uitzaaingen \r\n"+ "Deze klant gebruikt medicijnen \r\n"+ "Deze klant krijgt chemos \r\n"+"Deze klant krijgt Terapien \r\n",kankerinfo5.getInfo() );
    }
    private ArrayList<String> getData0(int uitzaaingen,int medicijnen,int chemos,int terapien){
        ArrayList<String> data = new ArrayList<>();
        data.add(getBoolean(uitzaaingen)+"");
        data.add(getBoolean(medicijnen)+"");
        data.add(getBoolean(chemos)+"");
        data.add(getBoolean(terapien)+"");
        return data;
    }
    private boolean getBoolean(int value){
        if(value ==1)
            return true;
        return false;
    }

}
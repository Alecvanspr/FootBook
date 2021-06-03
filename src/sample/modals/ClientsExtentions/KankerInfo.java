package sample.modals.ClientsExtentions;

import java.util.ArrayList;

public class KankerInfo extends ClientInfo{
    boolean uitzaaingen;
    boolean medicijnen;
    boolean chemos;
    boolean terapien;

    public KankerInfo(ArrayList<String> data){
        this.uitzaaingen = Boolean.parseBoolean(data.get(0));
        this.medicijnen = Boolean.parseBoolean(data.get(1));
        this.chemos = Boolean.parseBoolean(data.get(2));
        this.terapien = Boolean.parseBoolean(data.get(3));
    }
    public String getInfo(){
        String info = "Deze klant heeft kanker \r\n";
        if(uitzaaingen)
            info+= "\tDeze klant heeft last van uitzaaingen \r\n";
        if(medicijnen)
            info+= "\tDeze klant gebruikt medicijnen \r\n";
        if(chemos)
            info+= "\tDeze klant krijgt chemos \r\n";
        if(terapien)
            info+= "\tDeze klant krijgt Terapien \r\n";
        return info;
    }
}

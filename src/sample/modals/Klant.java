package sample.modals;

import java.util.ArrayList;

public class Klant extends Client{

    public Klant(ArrayList<String> data) {
        super(data);
    }
    public String getInfo(){
        String info = "";
        if(info.equals(""))
            return "er is geen speciale informatie weer te geven";
        return info;
    }
}

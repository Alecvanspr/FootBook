package sample.modals;

import java.util.ArrayList;

public class Klant extends Client{

    public Klant(ArrayList<String> data) {
        super(data);
    }
    public String getInfo(){
        String info = "";
        if(kanker){
            info+= kankerInfo.getInfo()+"\r\n";
        }
        if(diabetes!=null){
            info+= diabetes.getInfo()+"\r\n";
        }
        if(reuma!=null){
            info+= reuma.getInfo()+"\r\n";
        }
        if(soa!=null){
            info+= soa.getInfo()+"\r\n";
        }
        if(info.equals(""))
            return "er is geen speciale informatie weer te geven";
        return info;
    }
}

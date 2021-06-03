package sample.modals.ClientsExtentions;

import java.util.ArrayList;

public class SteunInfo extends ClientInfo{
    public Boolean kousen;
    public String orthopedischeAfwijkingen;
    public Boolean steunzolen;

    public SteunInfo(Boolean kousen,String orthopedischeAfwijkingen,Boolean steunzolen){
        this.kousen = kousen;
        this.orthopedischeAfwijkingen = orthopedischeAfwijkingen;
        this.steunzolen = steunzolen;
    }

    public String getInfo(){
        String string = "";
        if(kousen)
           string+="De klant heeft steunkousen";
        if(!orthopedischeAfwijkingen.contains("geen")){
            string+="De klant heeft "+orthopedischeAfwijkingen + " als orthopedische afwijking";
        }
        if(steunzolen)
            string+="De klant heeft steunzolen";
        return string;
    }
}

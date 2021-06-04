package sample.modals.ClientsExtentions;

public class NagelInfo extends ClientInfo {
    public String nagelConditie;
    public String nagelAandoening;
    public NagelInfo(String nagelConditie,String nagelAandoening){
        this.nagelConditie = nagelConditie;
        this.nagelAandoening = nagelAandoening;
    }

    @Override
    public String getInfo() {
        String string = "";
        if(!nagelConditie.equals("-"))
            string+="Nagelconditie: "+ nagelConditie + "\r\n";
        if(!nagelAandoening.equals("-"))
            string+="Nagelaandoening: "+ nagelAandoening;
        return string;
    }
}

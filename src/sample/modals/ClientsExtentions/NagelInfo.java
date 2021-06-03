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
        return "Deze klant heeft "+nagelAandoening+ " \r\nDe klant heeft een nagelconditie van"+ nagelConditie;
    }
}

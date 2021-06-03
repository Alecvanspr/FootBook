package sample.modals.ClientsExtentions;

public class HuidInfo extends ClientInfo {
    public String huidconditie;
    public String huidaandoening;

    public HuidInfo(String huidconditie, String huidaandoening) {
        this.huidconditie = huidconditie;
        this.huidaandoening = huidaandoening;
    }

    @Override
    public String getInfo() {
        return "De huidconditie van de klant is "+huidconditie+"\r\nDe klant lijd aan "+huidaandoening;
    }
}

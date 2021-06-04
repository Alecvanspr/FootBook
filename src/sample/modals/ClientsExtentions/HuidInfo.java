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
        String ret = "";
        if(!huidconditie.contains("-")) {
            ret += "De huidconditie: " + huidconditie + "\r\n";
        }
        if(!huidaandoening.contains("-")) {
            ret += "Huidaandoeningen: " + huidaandoening + "\r\n";
        }
        return ret;
    }
}

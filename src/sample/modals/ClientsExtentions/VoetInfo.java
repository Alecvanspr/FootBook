package sample.modals.ClientsExtentions;

public class VoetInfo extends ClientInfo {
    public String voettype;

    public VoetInfo(String voettype) {
    this.voettype = voettype;
    }

    @Override
    public String getInfo() {
        return "De klant heeft "+voettype;
    }
}

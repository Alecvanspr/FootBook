package sample.modals.ClientsExtentions;

public class AllergieInfo extends ClientInfo {
    public String allergien;
    public AllergieInfo(String allergien){
        this.allergien = allergien;
    }
    @Override
    public String getInfo() {
        return "Allergieën: "+ allergien;
    }
}

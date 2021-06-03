package sample.modals.ClientsExtentions;

public class SoaInfo extends ClientInfo{
    private String name;
    public SoaInfo(String soaNaam){
        this.name = soaNaam;
    }
    public String getInfo(){
        return "Deze klant heeft de soa "+ name;
    }
}

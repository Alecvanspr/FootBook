package sample.modals.ClientsExtentions;

public class SchoenInfo extends ClientInfo {
    public Boolean confectieSchoenen;
    public Boolean orthopedischeSchoenen;
    public SchoenInfo(Boolean conf,Boolean orth){
        this.confectieSchoenen = conf;
        this.orthopedischeSchoenen = orth;
    }

    @Override
    public String getInfo() {
        String string = "";
        if(confectieSchoenen){
            string+="Deze klant draagt ConfectieSchoenen\r\n";
        }
        if(orthopedischeSchoenen){
            string+="Deze klant draagt orthopedische schoenen\r\n";
        }
        return string;
    }
}

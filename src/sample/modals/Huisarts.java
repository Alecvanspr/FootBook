package sample.modals;

import java.util.ArrayList;

public class Huisarts extends Persoon{
    public String huisartsenpost;
    public String website;
    public Huisarts(ArrayList<String> data){
        if(data!=null) {
            this.id = data.get(0);
            this.naam = data.get(1);
            this.telefoonnr = data.get(2);
            this.adres = data.get(3);
            this.postcode = data.get(4);
            this.plaats = data.get(5);
            this.email = data.get(6);
            this.huisartsenpost = data.get(7);
            this.website = data.get(8);
        }
    }
}

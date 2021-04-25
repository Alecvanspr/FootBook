package sample.modals;

import java.util.ArrayList;

public class KankerPatient extends Client{
    public KankerPatient(ArrayList<String> data){
        this.id = data.get(0);
        this.naam = data.get(1);
        this.telefoonnr = data.get(2);
        this.adres = data.get(3);
        this.postcode = data.get(4);
        this.plaats = data.get(5);
        this.email = data.get(6);
        this.geboortedatum = maakDate(data.get(7));
        this.registratieNummer = data.get(8);
    }
}

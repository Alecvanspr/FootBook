package sample.modals;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sample.Database.Context;
import sample.Database.FileReader;

import java.util.ArrayList;
import java.util.Date;

//Client (Hier wordt de client aangemaakt)
//Getbahndelgeschiedenis
//makeDate

public class Client extends Persoon{
    public ArrayList<BehandelingHistory> behandelingen;
    public Date geboortedatum;
    public String registratieNummer;
    public Boolean diabetus;
    public Boolean reuma;
    public Boolean kanker;
    public Boolean soa;

    public Client(ArrayList<String> data){
        this.id = data.get(0);
        this.naam = data.get(1);
        this.telefoonnr = data.get(2);
        this.adres = data.get(3);
        this.postcode = data.get(4);
        this.plaats = data.get(5);
        this.email = data.get(6);
        this.geboortedatum = maakDate(data.get(7));
        this.registratieNummer = data.get(8);
        this.diabetus = Boolean.getBoolean(data.get(9));
        this.reuma = Boolean.getBoolean(data.get(10));
        this.kanker = Boolean.getBoolean(data.get(11)); //TODO DIT FIXEN
        this.soa = Boolean.getBoolean(data.get(12));
    }

    public ArrayList<BehandelingHistory> getBehandelingGeschiedenis() {
        if(behandelingen==null){
            behandelingen = new ArrayList<>();
            Context context = new Context();
            FileReader fileReader = new FileReader();
            ArrayList<String> data = new ArrayList<>();
            data = fileReader.getFile("klanten/"+id+"/BehandelingLog.txt");
            //Hier worden de 2 gegeven in verwerkt
            System.out.println(data.size());
            for(int i=0;i<data.size();i=i+3){
                BehandelingHistory behandelingHistory = new BehandelingHistory();
                behandelingHistory.datum = maakDate(data.get(i));
                behandelingHistory.type = context.findBehandeling(data.get(i+1));
                behandelingHistory.bijzonderheden= data.get(i);
                behandelingen.add(behandelingHistory);
            }
        }
        return behandelingen;
    }
    public Date maakDate(String datum){
        //Deze maakt de substrings
        int day = Integer.parseInt(datum.substring(0,2));
        int month = Integer.parseInt(datum.substring(3,5));
        int year = Integer.parseInt(datum.substring(6,10));
        //Deze maakt de Datum die uiteindelijk gereturned wordt.
        Date date = new Date();
        date.setYear(year);
        date.setMonth(month-1);
        date.setDate(day);
        return date;
    }
}

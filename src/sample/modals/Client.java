package sample.modals;

import sample.Database.Context;
import sample.Database.FileReader;

import java.util.ArrayList;
import java.util.Date;

//Client (Hier wordt de client aangemaakt)
//Getbahndelgeschiedenis
//makeDate

public abstract class Client extends Persoon{
    public ArrayList<BehandelingHistory> behandelingen;
    public Date geboortedatum;
    public String registratieNummer;
    public String typePatient;

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

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
    public Huisarts huisarts;
    public Boolean diabetus;
    public Specialist diatusSpecialist;
    public Boolean reuma;
    public Specialist reumatoloog;
    public Boolean kanker;
    public Specialist oncoloog;
    public Boolean soa;
    public String soanaam;
    public String allergenen;
    public Boolean kousen;
    public String voettype;
    public String orthopedischeAfwijkingen;
    public Boolean steunzolen;
    public Boolean confectieSchoenen;
    public Boolean orthopedischeSchoenen;
    public String huidconditie;
    public String huidaandoening;
    public String nagelConditie;
    public String nagelAandoening;

    public Client(ArrayList<String> data){
        Context context = Context.getContext();
        this.id = data.get(0);
        this.naam = data.get(1);
        this.telefoonnr = data.get(2);
        this.adres = data.get(3);
        this.postcode = data.get(4);
        this.plaats = data.get(5);
        this.email = data.get(6);
        this.geboortedatum = maakDate(data.get(7));
        this.registratieNummer = data.get(8);
        this.huisarts = context.getArts(data.get(9));
        this.diabetus = Boolean.getBoolean(data.get(10));
        if(diabetus)
        this.diatusSpecialist = context.getSpecialist(data.get(11));
        this.reuma = Boolean.getBoolean(data.get(12));
        if(reuma)
        this.reumatoloog = context.getSpecialist(data.get(13));
        this.kanker = Boolean.getBoolean(data.get(14));
        if(kanker)
            this.oncoloog = context.getSpecialist(data.get(15));
        this.soa = Boolean.getBoolean(data.get(16));
        this.soanaam = data.get(17);
        this.allergenen = data.get(18);
        this.kousen = Boolean.getBoolean(data.get(19));
        this.voettype = data.get(20);
        this.orthopedischeAfwijkingen = data.get(21);
        this.steunzolen = Boolean.getBoolean(data.get(22));
        this.confectieSchoenen = Boolean.getBoolean(data.get(23));
        this.orthopedischeSchoenen = Boolean.getBoolean(data.get(24));
        this.huidconditie = data.get(25);
        this.huidaandoening = data.get(26);
        this.nagelConditie = data.get(27);
        this.nagelAandoening = data.get(28);
    }

    public ArrayList<BehandelingHistory> getBehandelingGeschiedenis() {
        if(behandelingen==null){
            behandelingen = new ArrayList<>();
            Context context = new Context();
            FileReader fileReader = new FileReader();
            ArrayList<String> data = new ArrayList<>();
            data = fileReader.getFile("klanten/"+id+"/BehandelingLog.txt");

            //Hier worden de 2 gegeven in verwerkt
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
    public void addBehandeling(String date,String type,String sideNote){

    }
}
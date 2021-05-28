package sample.modals;

import sample.Database.Context;
import sample.Database.DateMaker;
import sample.Database.FileReader;
import sample.Database.FileUpdater;

import java.util.ArrayList;
import java.util.Date;

//Client (Hier wordt de client aangemaakt)
//Getbahndelgeschiedenis
//makeDate

public class Client extends Persoon{
    public ArrayList<BehandelingHistory> behandelingen;
    public ArrayList<Screening> screenings;
    public Date geboortedatum;
    public String registratieNummer;
    public Huisarts huisarts;
    public Boolean diabetes;
    public Specialist diatusSpecialist;
    public Boolean reuma;
    public Specialist reumatoloog;
    public Boolean kanker;
    public Specialist oncoloog;
    public Boolean chemos;
    public String medicijnen;
    public Boolean uitzaaingen;
    public String terapien;
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
        FileReader r = new FileReader();
        Context context = Context.getContext();
        this.id = data.get(0);
        this.naam = data.get(1);
        this.telefoonnr = data.get(2);
        this.adres = data.get(3);
        this.postcode = data.get(4);
        this.plaats = data.get(5);
        this.email = data.get(6);
        this.geboortedatum = DateMaker.maakDate(data.get(7));
        this.registratieNummer = data.get(8);
        this.huisarts = context.getHuisartsen().getArts(data.get(9));
        this.diabetes = makeBoolean(data.get(10));
        if(diabetes)
        this.diatusSpecialist = context.getSpecialisten().getSpecialist(data.get(11));
        this.reuma = makeBoolean(data.get(12));
        if(reuma)
        this.reumatoloog = context.getSpecialisten().getSpecialist(data.get(13));
        this.kanker = makeBoolean(data.get(14));
        if(kanker) {
            this.oncoloog = context.getSpecialisten().getSpecialist(data.get(15));
            this.chemos  = makeBoolean(data.get(16));
            this.medicijnen = data.get(17);
            this.uitzaaingen = makeBoolean(data.get(18));
            this.terapien = data.get(19);
        }
        this.soa = makeBoolean(data.get(20));
        this.soanaam = data.get(21);
        this.allergenen = data.get(22);
        this.kousen = makeBoolean(data.get(23));
        this.voettype = data.get(24);
        this.orthopedischeAfwijkingen = data.get(25);
        this.steunzolen = makeBoolean(data.get(26));
        this.confectieSchoenen = makeBoolean(data.get(27));
        this.orthopedischeSchoenen = makeBoolean(data.get(28));
        this.huidconditie = data.get(29);
        this.huidaandoening = data.get(30);
        this.nagelConditie = data.get(31);
        //this.nagelAandoening = data.get(32);
    }
    public Boolean makeBoolean(String bool){
        if(bool.equalsIgnoreCase("true"))
            return true;
        return false;
    }
    public ArrayList<BehandelingHistory> getBehandelingGeschiedenis() {
        if(behandelingen==null){
            behandelingen = new ArrayList<>();
            Context context = new Context();
            FileReader fileReader = new FileReader();
            ArrayList<String> data = fileReader.getFile("klanten/"+id+"/BehandelingLog.txt");

            //Hier worden de 2 gegeven in verwerkt
            for(int i=0;i<data.size();i=i+3){
                ArrayList<String> behandelData= new ArrayList<>();
                behandelData.add(data.get(i));
                behandelData.add(data.get(i+1));
                behandelData.add(data.get(i+2));
                behandelingen.add(new BehandelingHistory(behandelData));
            }
        }
        return behandelingen;
    }
    //deze class is voor de behandel geschiedenis.
    public void addBehandeling(String date,String type,String sideNote){
        FileUpdater fileUpdater = new FileUpdater();
        ArrayList<String> data = new ArrayList<>();
        data.add(date);
        data.add(type);
        data.add(sideNote);
        fileUpdater.addBehandeling(id,data);
    }
    public double travelDistance(){
        FileReader reader = new FileReader();
        ArrayList<String> plaatsen = reader.getFile("Plaatsen.txt");
        for (int i=1; i<plaatsen.size()-1;i++)
        if(plaats.equalsIgnoreCase(plaatsen.get(i))){
            return Double.parseDouble(plaatsen.get(i+1));
        }
        return 0.0;
    }
    public boolean allowScreening(){
        if((kanker&&reuma)|| diabetes){
            return true;
        }
        return false;
    }
}

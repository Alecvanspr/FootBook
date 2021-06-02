package sample.modals;

import sample.Database.Context;
import sample.Database.DateMaker;
import sample.Database.FileReader;
import sample.modals.ClientsExtentions.DiabetisInfo;
import sample.modals.ClientsExtentions.KankerInfo;
import sample.modals.ClientsExtentions.ReumaInfo;
import sample.modals.ClientsExtentions.SoaInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

//Client (Hier wordt de client aangemaakt)
//Getbahndelgeschiedenis
//makeDate

public abstract class Client extends Persoon{
    public BehandelList behandelList;
    public Date geboortedatum;
    public String registratieNummer;
    public Huisarts huisarts;
    public DiabetisInfo diabetes;
    public Specialist diatusSpecialist;
    public ReumaInfo reuma;
    public Specialist reumatoloog;
    public Boolean kanker;
    public KankerInfo kankerInfo;
    public Specialist oncoloog;
    public SoaInfo soa;
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
        this.huisarts = Context.getHuisartsen().getArts(data.get(9));
        if(Boolean.parseBoolean(data.get(10))) {
            this.diatusSpecialist = Context.getSpecialisten().getSpecialist(data.get(11));
            this.diabetes = new DiabetisInfo();
        }
        if(Boolean.parseBoolean(data.get(12))){
            this.reuma = new ReumaInfo();
            this.reumatoloog = Context.getSpecialisten().getSpecialist(data.get(13));
        }
        this.kanker = Boolean.parseBoolean(data.get(14));
        if(kanker) {
            this.oncoloog = Context.getSpecialisten().getSpecialist(data.get(15));
            System.out.println(oncoloog.naam);
            kankerInfo = new KankerInfo(getSubArray(16,19,data));
        }
        if(Boolean.parseBoolean(data.get(20))) {
            this.soa= new SoaInfo(data.get(21));
        }
        this.allergenen = data.get(22);
        this.kousen = Boolean.parseBoolean(data.get(23));
        this.voettype = data.get(24);
        this.orthopedischeAfwijkingen = data.get(25);
        this.steunzolen = Boolean.parseBoolean(data.get(26));
        this.confectieSchoenen = Boolean.parseBoolean(data.get(27));
        this.orthopedischeSchoenen = Boolean.parseBoolean(data.get(28));
        this.huidconditie = data.get(29);
        this.huidaandoening = data.get(30);
        this.nagelConditie = data.get(31);
        //this.nagelAandoening = data.get(32);
        this.behandelList = new BehandelList(id);
    }

    private ArrayList<String> getSubArray(int begin,int end,ArrayList<String>data){
        ArrayList<String> ret = new ArrayList<>();
        for(int i = begin; i<=end;i++){
            ret.add(data.get(i));
        }
        return ret;
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
        if((kanker&&reuma!=null)|| diabetes!=null){
            return true;
        }
        return false;
    }

    public abstract String getInfo();
}

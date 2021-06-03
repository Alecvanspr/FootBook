package sample.modals;

import sample.Database.Context;
import sample.Database.DateMaker;
import sample.Database.FileReader;
import sample.Database.SubStringMaker;
import sample.modals.ClientsExtentions.*;

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
    public NagelInfo nagel;
    public HuidInfo huid;
    public SchoenInfo schoen;
    public AllergieInfo allergenen;
    public SteunInfo steun;
    public VoetInfo voet;

    public Client(ArrayList<String> data){
        this.id = data.get(0);
        this.naam = data.get(1);
        this.telefoonnr = data.get(2);
        this.adres = data.get(3);
        this.postcode = data.get(4);
        this.plaats = data.get(5);
        this.email = data.get(6);
        this.geboortedatum = DateMaker.maakDate(data.get(7));
        this.registratieNummer = data.get(8);
        this.huisarts = Context.getHuisartsen().get(data.get(9));
        if(Boolean.parseBoolean(data.get(10))) {
            this.diatusSpecialist = Context.getSpecialisten().get(data.get(11));
            this.diabetes = new DiabetisInfo();
        }
        if(Boolean.parseBoolean(data.get(12))){
            this.reuma = new ReumaInfo();
            this.reumatoloog = Context.getSpecialisten().get(data.get(13));
        }
        this.kanker = Boolean.parseBoolean(data.get(14));
        if(kanker) {
            this.oncoloog = Context.getSpecialisten().get(data.get(15));
            kankerInfo = new KankerInfo(SubStringMaker.sub(16,19,data));
        }
        if(Boolean.parseBoolean(data.get(20))) {
            this.soa= new SoaInfo(data.get(21));
        }
        this.allergenen = new AllergieInfo(data.get(22));
        if(data.get(31).equals(" ")){
            nagel = new NagelInfo(data.get(31),data.get(32));
        }
        if(Boolean.parseBoolean(data.get(23))&&Boolean.parseBoolean(data.get(26)))
            steun = new SteunInfo(Boolean.parseBoolean(data.get(23)), data.get(25), Boolean.parseBoolean(data.get(26)));
        this.voet = new VoetInfo(data.get(24));
        this.schoen = new SchoenInfo(Boolean.parseBoolean(data.get(27)),Boolean.parseBoolean(data.get(28)));
        if(data.get(29).equals("")&& data.get(30).equals("")){
            huid = new HuidInfo(data.get(29),data.get(30));
        }
        this.behandelList = new BehandelList(id);
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

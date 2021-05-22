package sample.Database;

import sample.modals.Huisarts;

import java.util.ArrayList;
import java.util.LinkedList;

public class Huisartsen {
    private static LinkedList<Huisarts> Huisartsen;
    private static int MaxArtsen;
    private static Huisartsen instance;

    public Huisartsen(){
        MaxArtsen = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxHuisartsen.txt"));
        fillArtsen();
    }
    public void fillArtsen(){
        Huisartsen = new LinkedList<>();
        for(int i = 0; i<=MaxArtsen; i++){
            Huisarts arts =getArtsFile(""+i);
            if(arts!=null) {
                Huisartsen.addLast(arts);
            }
        }
    }
    public static Huisartsen getInstance(){
        if(instance==null){
            instance = new Huisartsen();
        }
        return instance;
    }
    //hier wordt de arts gehaald uit de linked list.
    public Huisarts getArts(String id){
        for(int i = 0; i<Huisartsen.size();i++){
            if(id.equals(Huisartsen.get(i).id))
                return Huisartsen.get(i);
        }
        return null;
    }
    //dit haald de bestanden uit het bestand zelf
    private Huisarts getArtsFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("huisartsen/"+id+".txt")!=null)
            return new Huisarts(r.getFile("huisartsen/" +id+".txt"));
        return null;
    }
    public void makeNewHuisarts(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("Huisartsen",data.toArray());
        Huisartsen.add(new Huisarts(data));
    }
    public LinkedList<Huisarts> getHuisartsen() {
        return Huisartsen;
    }
    public LinkedList<Huisarts> getHuisartsen(String filter){
        LinkedList ret = new LinkedList();
        for(int i =0; i<Huisartsen.size();i++){
            if(Huisartsen.get(i).naam.toLowerCase().contains(filter.toLowerCase())||Huisartsen.get(i).id.contains(filter)||Huisartsen.get(i).huisartsenpost.toLowerCase().contains(filter.toLowerCase()))
            ret.add(Huisartsen.get(i));
        }
        return  ret;
    }
    public void editHuisarts(ArrayList data){
        FileUpdater fileUpdater = new FileUpdater();
        fileUpdater.updateFile("src/db/Huisartsen/"+data.get(0)+".txt",data);
        changeHuisarts(data);
    }
    private void changeHuisarts(ArrayList<String> data){
        for(int i = 0;i<Huisartsen.size();i++){
            if(Huisartsen.get(i).id.equals(data.get(0))){
                Huisartsen.get(i).naam = data.get(1);
                Huisartsen.get(i).telefoonnr = data.get(2);
                Huisartsen.get(i).adres = data.get(3);
                Huisartsen.get(i).postcode = data.get(4);
                Huisartsen.get(i).plaats = data.get(5);
                Huisartsen.get(i).email = data.get(6);
                Huisartsen.get(i).huisartsenpost = data.get(7);
                Huisartsen.get(i).huisartsenpost = data.get(8);
            }
        }
    }
}

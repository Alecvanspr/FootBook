package sample.Database;

import sample.modals.Huisarts;

import java.util.ArrayList;
import java.util.LinkedList;

public class Huisartsen {
    private static LinkedList<Huisarts> Huisartsen;
    private static int MaxArtsen;
    private static Huisartsen instance;

    public Huisartsen(){
        FileReader reader = new FileReader();
        MaxArtsen = Integer.parseInt(reader.getUniqueNumber("src/db/MaxHuisartsen.txt"));
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
        createFile.CreatePersoon("Artsen",data.toArray());
        Huisartsen.add(new Huisarts(data));
    }
    public LinkedList<Huisarts> getHuisartsen() {
        return Huisartsen;
    }
}

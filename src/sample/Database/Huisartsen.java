package sample.Database;

import sample.modals.Huisarts;

import java.util.ArrayList;
import java.util.LinkedList;

public class Huisartsen implements ContextClass {
    private static LinkedList<Huisarts> Huisartsen;
    private static int MaxArtsen;

    public Huisartsen(){
        MaxArtsen = Integer.parseInt(uniqueNumber.getUniqueNumber("src/db/MaxHuisartsen.txt"));
        fillList();
    }
    public void fillList(){
        Huisartsen = new LinkedList<>();
        for(int i = 0; i<=MaxArtsen; i++){
            Huisarts arts = getFromFile(""+i);
            if(arts!=null) {
                Huisartsen.addLast(arts);
            }
        }
    }
    //hier wordt de arts gehaald uit de linked list.
    public Huisarts get(String id){
        for(int i = 0; i<Huisartsen.size();i++){
            if(id.equals(Huisartsen.get(i).id))
                return Huisartsen.get(i);
        }
        return null;
    }
    public int getPlace(String id){
        for(int i = 0;i<Huisartsen.size();i++){
            if(id.equals(Huisartsen.get(i).id))
                return i;
        }
        return 0;
    }
    //dit haald de bestanden uit het bestand zelf
    public Huisarts getFromFile(String id){
        if(reader.getFile("huisartsen/"+id+".txt")!=null)
            return new Huisarts(reader.getFile("huisartsen/" +id+".txt"));
        return null;
    }
    public void create(ArrayList<String> data){
        createFile.CreateNewFile("Huisartsen",data.toArray());
        Huisartsen.add(new Huisarts(data));
    }
    public LinkedList<Huisarts> getList() {
        return Huisartsen;
    }
    public LinkedList<Huisarts> getList(String filter){
        LinkedList ret = new LinkedList();
        for(int i =0; i<Huisartsen.size();i++){
            if(Huisartsen.get(i).naam.toLowerCase().contains(filter.toLowerCase())||Huisartsen.get(i).id.contains(filter)||Huisartsen.get(i).huisartsenpost.toLowerCase().contains(filter.toLowerCase()))
            ret.add(Huisartsen.get(i));
        }
        return  ret;
    }
    public void editHuisarts(ArrayList data){
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

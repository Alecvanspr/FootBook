package sample.Database.ContextClasses;

import sample.Database.Managers.MaxFiles;
import sample.modals.Personen.Specialist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Specialisten implements ContextClass{
    private static LinkedList<Specialist> specialisten;

    public Specialisten(){
        fillList();
    }

    @Override
    public MaxFiles getMax() {
        return new MaxFiles("src/db/MaxSpecialisten.txt");
    }

    public void fillList(){
        specialisten = new LinkedList<>();
        for(int i = 0; i<=getMax().getMaxFiles(); i++){
            Specialist specialist = getFromFile(""+i);
            if(specialist!=null) {
                specialisten.addLast(specialist);
            }
        }
    }
    //hier wordt gesorteerd op het klantId
    public Specialist get(String id){
        for(int i = 0; i<specialisten.size();i++){
            if(id.equals(specialisten.get(i).id))
                return specialisten.get(i);
        }
        return null;
    }
    public Specialist getFromFile(String id){
        if(reader.getFile("specialisten/"+id+".txt")!=null)
            return new Specialist(reader.getFile("specialisten/"+id+".txt"));
        return null;
    }
    public LinkedList<Specialist> getList() {
        return specialisten;
    }

    public LinkedList<Specialist> getList(String filter) {
        LinkedList<Specialist> ret = new LinkedList();
        for(int i =0; i<specialisten.size();i++){
            if(specialisten.get(i).naam.toLowerCase().contains(filter.toLowerCase())||specialisten.get(i).id.contains(filter)||specialisten.get(i).specialiteit.toLowerCase().contains(filter.toLowerCase()))
                ret.add(specialisten.get(i));
        }
        return  ret;
    }

    public void create(ArrayList<String> data){
        createFile.CreateNewFile("Specialisten", data.toArray());
        fillList();
    }
    public void editSpecialist(ArrayList<String> data){
        fileUpdater.updateFile("src/db/Specialisten/"+data.get(0)+".txt",data);
        fillList();
    }

    public int getPlace(String id) {
        for(int i = 0; i< getList().size(); i++){
            if(getList().get(i).id.equals(id))
                return i;
        }
        return 0;
    }
}

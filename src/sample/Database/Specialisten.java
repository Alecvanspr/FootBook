package sample.Database;

import sample.modals.Specialist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Specialisten {
    private static LinkedList<Specialist> specialisten;
    private static int MaxSpecialisten;
    private static Specialisten instance;

    public Specialisten(){
        FileReader reader = new FileReader();
        MaxSpecialisten = Integer.parseInt(reader.getUniqueNumber("src/db/MaxSpecialisten.txt"));
        fillSpecialisten();
    }
    public void fillSpecialisten(){
        specialisten = new LinkedList<>();
        for(int i = 0; i<=MaxSpecialisten; i++){
            Specialist specialist =getSpecialistFile(""+i);
            if(specialist!=null) {
                specialisten.addLast(specialist);
            }
        }
    }
    public static Specialisten getInstance(){
        if(instance==null){
            instance = new Specialisten();
        }
        return instance;
    }
    //hier wordt gesorteerd op het klantId
    public Specialist getSpecialist(String id){
        for(int i = 0; i<specialisten.size();i++){
            if(id.equals(specialisten.get(i).id))
                return specialisten.get(i);
        }
        return null;
    }
    private Specialist getSpecialistFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("specialisten/"+id+".txt")!=null)
            return new Specialist(r.getFile("specialisten/"+id+".txt"));
        return null;
    }
    public LinkedList<Specialist> getSpecialisten() {
        return specialisten;
    }

    public LinkedList<Specialist> getSpecialisten(String filter) {
        LinkedList<Specialist> ret = new LinkedList();
        for(int i =0; i<specialisten.size();i++){
            if(specialisten.get(i).naam.toLowerCase().contains(filter.toLowerCase())||specialisten.get(i).id.contains(filter)||specialisten.get(i).specialiteit.toLowerCase().contains(filter.toLowerCase()))
                ret.add(specialisten.get(i));
        }
        return  ret;
    }

    public void makeNewSpecialist(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("Specialisten", data.toArray());
        specialisten.add(new Specialist(data));
    }
    public void editSpecialist(ArrayList<String> data){
        FileUpdater fileUpdater = new FileUpdater();
        fileUpdater.updateFile("src/db/Specialisten/"+data.get(0)+".txt",data);
        changeSpecialist(data.get(0),data);
    }
    private void changeSpecialist(String id,ArrayList<String> data){
        for(int i=0; i<specialisten.size(); i++){
            if(specialisten.get(i).id.equals(id)){
                specialisten.get(i).naam = data.get(1);
                specialisten.get(i).telefoonnr = data.get(2);
                specialisten.get(i).adres = data.get(3);
                specialisten.get(i).postcode = data.get(4);
                specialisten.get(i).plaats = data.get(5);
                specialisten.get(i).email = data.get(6);
                specialisten.get(i).ziekenhuis = data.get(7);
                specialisten.get(i).specialiteit = data.get(8);
            }
        }
    }
}

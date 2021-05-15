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

    public void makeNewSpecialist(ArrayList<String> data){
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("Specialisten", data.toArray());
        specialisten.add(new Specialist(data));
    }
}

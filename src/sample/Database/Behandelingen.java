package sample.Database;

import sample.modals.Behandeling;

import java.util.ArrayList;
import java.util.LinkedList;

public class Behandelingen implements ContextClass{
    private static LinkedList<Behandeling> behandelingen;
    private static int MaxBehandelingen;

    public Behandelingen(){
        MaxBehandelingen = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxBehandelingen.txt"));
        fillList();
    }
    @Override
    public void fillList(){
        behandelingen = new LinkedList<>();
        for (int i = 0; i < MaxBehandelingen; i++) {
            Behandeling behandeling = getFromFile("" + i);
            if (behandeling != null) {
                behandelingen.addLast(behandeling);
            }
        }
    }
    @Override
    public Behandeling getFromFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("behandelingen/"+id+".txt")!=null)
            return new Behandeling(r.getFile("behandelingen/"+id+".txt"));
        return null;
    }

    public Behandeling get(String id){
        for(int i=0;i<behandelingen.size();i++){
            if(behandelingen.get(i).id.equals(id)){
                return behandelingen.get(i);
            }
        }
        return null;
    }

    public int getID(String behandelingName){
        for(int i=0;i<behandelingen.size();i++){
            if(behandelingen.get(i).naam.equals(behandelingName))
                return Integer.parseInt(behandelingen.get(i).id);
        }
        return 1;
    }

    public LinkedList<Behandeling> getList() {
        return behandelingen;
    }

    @Override
    public void create(ArrayList<String> data) {
        CreateFile createFile = new CreateFile();
        String id = UniqueNumber.getUniqueNumber("src/db/MaxBehandelingen.txt");
        createFile.CreateNewFile("Behandelingen", data.toArray());
        behandelingen.add(new Behandeling(new FileReader().getFile("behandelingen/"+id+".txt")));
    }

    @Override
    public int getPlace(String id) {
        for(int i =0;i<behandelingen.size();i++){
            if(behandelingen.get(i).id.equals(id)){
                return i;
            }
        }
        return 0;
    }

}

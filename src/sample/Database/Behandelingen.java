package sample.Database;

import sample.modals.Behandeling;

import java.util.ArrayList;
import java.util.LinkedList;

public class Behandelingen {
    private static LinkedList<Behandeling> behandelingen;
    private static int MaxBehandelingen;
    private static Behandelingen instance;

    public Behandelingen(){
        MaxBehandelingen = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxBehandelingen.txt"));
        fillBehandelingenList();
    }

    private void fillBehandelingenList(){
        behandelingen = new LinkedList<>();
        for (int i = 0; i < MaxBehandelingen; i++) {
            Behandeling behandeling = getBehandelingFile("" + i);
            if (behandeling != null) {
                behandelingen.addLast(behandeling);
            }
        }
    }
    private Behandeling getBehandelingFile(String id){
        FileReader r = new FileReader();
        if(r.getFile("behandelingen/"+id+".txt")!=null)
            return new Behandeling(r.getFile("behandelingen/"+id+".txt"));
        return null;
    }
    public Behandeling getBehandeling(String id){
        for(int i=0;i<behandelingen.size();i++){
            if(behandelingen.get(i).id.equals(id)){
                return behandelingen.get(i);
            }
        }
        return null;
    }
    public int getBehandelingID(String behandelingName){
        for(int i=0;i<behandelingen.size();i++){
            if(behandelingen.get(i).naam.equals(behandelingName))
                return Integer.parseInt(behandelingen.get(i).id);
        }
        return 1;
    }
    public LinkedList<Behandeling> getBehandelingen() {
        return behandelingen;
    }
    public void makeBehandeling(ArrayList<String> data) {
        CreateFile createFile = new CreateFile();
        String id = UniqueNumber.getUniqueNumber("src/db/MaxBehandelingen.txt");
        createFile.CreatePersoon("Behandelingen", data.toArray());
        behandelingen.add(new Behandeling(new FileReader().getFile("behandelingen/"+id+".txt")));
    }

}

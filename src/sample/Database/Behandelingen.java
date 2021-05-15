package sample.Database;

import sample.modals.Behandeling;

import java.util.ArrayList;
import java.util.LinkedList;

public class Behandelingen {
    private static LinkedList<Behandeling> behandelingen;
    private static int MaxBehandelingen;
    private static Behandelingen instance;

    public Behandelingen(){
        FileReader reader = new FileReader();
        MaxBehandelingen = Integer.parseInt(reader.getUniqueNumber("src/db/MaxBehandelingen.txt"));
        fillBehandelingenList();
    }

    public static Behandelingen getInstance(){
        if(instance==null){
            instance = new Behandelingen();
        }
        return instance;
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
    public LinkedList<Behandeling> getBehandelingen() {
        return behandelingen;
    }
    public void makeBehandeling(ArrayList<String> data) {
        CreateFile createFile = new CreateFile();
        createFile.CreatePersoon("Behandelingen", data.toArray());
        behandelingen.add(new Behandeling(data));
    }

}

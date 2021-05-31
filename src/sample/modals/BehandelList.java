package sample.modals;

import sample.Database.Context;
import sample.Database.FileReader;
import sample.Database.FileUpdater;

import java.util.ArrayList;

public class BehandelList {
    private ArrayList<BehandelingHistory> behandelingen;
    private String clientID;

    public BehandelList(String id){
        this.clientID = id;
        behandelingen = new ArrayList<>();
        Context context = new Context();
        FileReader fileReader = new FileReader();
        ArrayList<String> data = fileReader.getFile("klanten/"+id+"/BehandelingLog.txt");
        //Hier worden de 2 gegeven in verwerkt
        fillList(data);

    }
    private void fillList(ArrayList<String> data){
        for(int i=0;i<data.size();i=i+3){
            ArrayList<String> behandelData= new ArrayList<>();
            behandelData.add(data.get(i));
            behandelData.add(data.get(i+1));
            behandelData.add(data.get(i+2));
            behandelingen.add(new BehandelingHistory(behandelData));
        }
    }

    public ArrayList<BehandelingHistory> getBehandelingGeschiedenis() {
        return behandelingen;
    }
    //deze class is voor de behandel geschiedenis.
    public void addBehandeling(String date,String type,String sideNote){
        FileUpdater fileUpdater = new FileUpdater();
        ArrayList<String> data = new ArrayList<>();
        data.add(date);
        data.add(type);
        data.add(sideNote);
        fileUpdater.addBehandeling(clientID,data);
    }
}


package sample.Database.Managers;

import sample.Database.Managers.FileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileUpdater {
    public void addBehandeling(String id,ArrayList<String> new_Data){
        FileReader r = new FileReader();
        //hieronder wordt de data van het gevraagde bestand opgehaald en aan het einde wordt daar de nieuwe data toegevoegd
        ArrayList<String> data = r.getFile("klanten/"+id+"/BehandelingLog.txt");
        data.addAll(new_Data);
        try {
            FileWriter writer = new FileWriter("src/db/klanten/"+id+"/BehandelingLog.txt");
            for (String datum : data) writer.write(datum + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void updateFile(String path,ArrayList<String> newData){
        try{
            PrintWriter writer = new PrintWriter(path);
            for(int i = 0;i<newData.size();i++) {
                writer.println(newData.toArray()[i]);
            }
            writer.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

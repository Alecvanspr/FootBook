package sample.Database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

//addbehandeling
//maakdatum

public class FileUpdater {
    public void addBehandeling(String id,ArrayList<String> new_Data){
        FileReader r = new FileReader();
        //hieronder wordt de data van het gevraagde bestand opgehaald en aan het einde wordt daar de nieuwe data toegevoegd
        ArrayList<String> data = r.getFile("klanten/"+id+"/BehandelingLog.txt.txt");
        data.addAll(new_Data);
        try {
            FileWriter writer = new FileWriter("src/db/klanten/"+id+"/BehandelingLog.txt.txt");
            for (String datum : data) writer.write(datum + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public void updateFile(String type,ArrayList<String> newData){
        try{
            int id = Integer.parseInt(newData.get(0));
            String path = createPath(type,id);
            CreateFile createFile = new CreateFile();
            PrintWriter writer = new PrintWriter(path);
            for(int i = 0;i<newData.size();i++)
                writer.println(newData.toArray()[i]);
            writer.close();;

        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String createPath(String type,int UniqueNumber){
        FileReader reader = new FileReader();
        String path ="src/db/"+type;

        //dit is voor het maken voor de dossiers
        if(type.equals("klanten")) {
            path = "src/db/" + type + "/" + UniqueNumber;
        }

        return path+"/"+ UniqueNumber+ ".txt";
    }
    public String maakDatum(Date datum){
        String jaar = ""+(datum.getYear()+1900);
        String maand = ""+ (datum.getMonth()+1);
        String dag = ""+ (datum.getDay()+2);
        if(maand.length()==1)
            maand=0+maand;
        if(dag.length()==1)
            dag=0+dag;
        return dag+"-"+maand+"-"+jaar;
    }
}

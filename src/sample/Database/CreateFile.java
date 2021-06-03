package sample.Database;

import sun.management.counter.Units;

import java.io.*;

//CreateFile
//CreateKlant
//CreatePath

public class CreateFile {

    public CreateFile(){

    }
    //Dit is voor het maken het vullen van een textbestand
    public void CreateNewFile(String type, Object[] data) {
        try {
            int UniqueNumber = sample.Database.UniqueNumber.getNewUniqueNumber(Pathmaker.getPath(type));
            String path = Pathmaker.createPath(type,UniqueNumber);
            File nieuwBestand = new File(path);
            if (nieuwBestand.createNewFile()) {
                for(int i=0;i<Pathmaker.getTypen().length;i++) {
                    if (type.equalsIgnoreCase(Pathmaker.getTypen()[i])) {
                        WriteNewFile(data, path, UniqueNumber);
                        if(Pathmaker.getTypen()[i].equalsIgnoreCase("Klanten")){
                            File behandelingen = new File("src/db/klanten/"+UniqueNumber+"/BehandelingLog.txt");
                            behandelingen.createNewFile();
                        }
                    }

                }
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void WriteNewFile(Object[] data, String path, int UniqueNumber){
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.println(UniqueNumber);
            for(int i = 0;i<data.length;i++)
                writer.println(data[i]);
            writer.close();
        }catch (IOException e){
            System.out.println("ERROR er gaat iets goed fout");
        }
    }
}

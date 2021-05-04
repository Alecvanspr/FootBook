package sample.Database;

import java.io.*;

//CreateFile
//CreateKlant
//CreatePath

public class CreateFile {
    public String[] typen = new String[]{"Klanten","Artsen","Specialisten","Behandelingen","Producten"};
    public CreateFile(){

    }
    //Dit is voor het maken het vullen van een textbestand
    public void CreatePersoon(String type, Object[] data) {
        try {
            int UniqueNumber = getUniqueNumber(type);
            String path = createPath(type,UniqueNumber);
            File nieuwBestand = new File(path);
            if (nieuwBestand.createNewFile()) {
                for(int i=0;i<typen.length;i++) {
                    if (type.equalsIgnoreCase(typen[i])) {
                        WriteClient(data, path, UniqueNumber);
                        if(typen[i].equalsIgnoreCase("Klanten")){
                            File behandelingen = new File("src/db/klanten/"+UniqueNumber+"/BehandelingLog.txt");
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

    private void WriteClient(Object[] data,String path,int UniqueNumber){
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.println(UniqueNumber);
            for(int i = 0;i<data.length;i++)
                writer.println(data[i]);
            writer.close();
        }catch (IOException e){
            System.out.println("ERROR er gaat iets goed fout met het aanmaken van de client");
        }
    }

    //dit is voor het maken van een pad voor de file. Dit zorgt ervoor dat ik niet 3 verschillende methods heb.
    private String getPath(String type){
        for(int i =0; i<typen.length;i++){
            if(type.equalsIgnoreCase(typen[i])){
                return "src/db/Max"+typen[i]+".txt";
            }
        }
        return null;
    }
    //deze methode die haalt het Unique number uit de file en Update deze ook gelijk.
    private int getUniqueNumber(String type) {
            int UniqueNumber = 0;
            try {
                FileReader reader = new FileReader();
                String path = getPath(type);
                UniqueNumber = Integer.parseInt(reader.getUniqueNumber(path));
                PrintWriter UniqueNumberFile = new PrintWriter(path);
                UniqueNumberFile.println(UniqueNumber + 1); // hier wordt het nummer wat in het bestand staat geüpdate;
                UniqueNumberFile.close();
            }catch (IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return UniqueNumber;
    }

    public String createPath(String type,int UniqueNumber){
        FileReader reader = new FileReader();
        String path ="src/db/" + type;

        //dit is voor het maken voor de dossiers
        if(!type.equals("behandelingen")&&!type.equals("producten")) {
            path = "src/db/" + type + "/" + UniqueNumber;
            File map = new File(path);
            map.mkdirs();
        }

        return path+"/"+ UniqueNumber+ ".txt";
    }
}

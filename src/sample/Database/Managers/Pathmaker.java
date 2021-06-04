package sample.Database.Managers;

import sample.Database.Managers.FileReader;

import java.io.File;

public class Pathmaker {
    private static String[] typen = new String[]{"Klanten","Huisartsen","Specialisten","Behandelingen","Producten"};

    public static String[] getTypen(){return typen;}
    public static String getPath(String type){
        for(int i =0; i<typen.length;i++){
            if(type.equalsIgnoreCase(typen[i])){
                return "src/db/Max"+typen[i]+".txt";
            }
        }
        return null;
    }

    public static String createPath(String type,int UniqueNumber){
        FileReader reader = new FileReader();
        String path ="src/db/" + type;

        //dit is voor het maken voor de dossiers
        if(type.equals("klanten")) {
            path = "src/db/" + type + "/" + UniqueNumber;
            File map = new File(path);
            map.mkdirs();
        }

        return path+"/"+ UniqueNumber+ ".txt";
    }

}

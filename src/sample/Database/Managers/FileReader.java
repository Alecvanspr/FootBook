package sample.Database.Managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

//GetFile
//GetUniqueNumber

public class FileReader {
    public ArrayList<String> getFile(String name){
        ArrayList<String> ret = new ArrayList<>();
        try {
            File myObj = new File("src/db/"+ name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ret.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            ret=null;
        }
        return ret;
    }
}

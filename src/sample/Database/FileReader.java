package sample.Database;

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

    public String getUniqueNumber(String path){
        String ret = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                ret = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return ret;
    }
}

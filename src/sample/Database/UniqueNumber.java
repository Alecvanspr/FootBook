package sample.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UniqueNumber {
    public static String getUniqueNumber(String path){
        String ret = "";
        if(path!=(null)) {
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
        }
        return ret;
    }

    //deze methode die haalt het Unique number uit de file en Update deze ook gelijk.
    public static int getNewUniqueNumber(String path) {
        int id = 0;
        try {
            FileReader reader = new FileReader();
            System.out.println(path);
            id = Integer.parseInt(UniqueNumber.getUniqueNumber(path));
            PrintWriter UniqueNumberFile = new PrintWriter(path);
            UniqueNumberFile.println((id + 1)+""); // hier wordt het nummer wat in het bestand staat geüpdate;
            UniqueNumberFile.close();
        }catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return id;
    }
}

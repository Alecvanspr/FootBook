package sample.Database;

import java.io.File;

public class DeleteFile {
    public void removeFile(String path){
        File file = new File(path);
        if(file.delete()){
            System.out.println(path+ " is no more");
        }
    }
}

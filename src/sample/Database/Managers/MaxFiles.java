package sample.Database.Managers;

public class MaxFiles {
    private int maxFiles;

    public MaxFiles(String path){
        maxFiles = Integer.parseInt(UniqueNumber.getUniqueNumber("src/db/MaxKlanten.txt"));
    }

    public int getMaxFiles() {
        return maxFiles;
    }
}

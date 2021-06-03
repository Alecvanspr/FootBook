package sample.Database;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public interface ContextClass {
    public FileReader reader = new FileReader();
    public CreateFile createFile = new CreateFile();
    public FileUpdater fileUpdater = new FileUpdater();
    public UniqueNumber uniqueNumber = new UniqueNumber();
    public void fillList();
    public Object getFromFile(String id);
    public Object get(String id);
    public void create(ArrayList<String> data);
    public int getPlace(String id);
}

package sample.Database.ContextClasses;

import sample.Database.Managers.FileReader;
import sample.Database.Managers.FileUpdater;
import sample.Database.Managers.MaxFiles;
import sample.Database.Managers.UniqueNumber;

import java.util.ArrayList;

public interface ContextClass {
    MaxFiles getMax();
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

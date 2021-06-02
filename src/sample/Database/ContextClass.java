package sample.Database;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ContextClass {
    public void fillList();
    public Object getFromFile(String id);
    public Object get(String id);
    public void create(ArrayList<String> data);
    public int getPlace(String id);
}

package sample.Database.Tools;

import java.util.ArrayList;

public class SubStringMaker {
    public static ArrayList<String> sub(int begin,int eind,ArrayList<String> data){
        ArrayList<String> ret = new ArrayList<>();
        for(int i=begin;i<=eind;i++){
            ret.add(data.get(i));
        }
        return ret;
    }
}

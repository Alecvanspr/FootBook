package sample.Database;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateMaker {
    public static Date maakDate(String datum) {
        //Deze maakt de substrings
        int day = Integer.parseInt(datum.substring(0, 2));
        int month = Integer.parseInt(datum.substring(3, 5));
        int year = Integer.parseInt(datum.substring(6, 10));
        //Deze maakt de Datum die uiteindelijk gereturned wordt.
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        return date;
    }
    //Deze method maakt van de datums een string.
    public static String maakDate(Date datum){
        String jaar = ""+(datum.getYear()+1900);
        String maand = ""+ (datum.getMonth()+1);
        String dag = ""+ (datum.getDate());
        if(maand.length()==1)
            maand=0+maand;
        if(dag.length()==1)
            dag=0+dag;
        return dag+"-"+maand+"-"+jaar;
    }
}

package sample.Database;

import sample.modals.*;
import sun.misc.Cleaner;

import java.io.File;
import java.io.FileWriter;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Context {
    private static Context context;
    public static Clients clients;
    public static Huisartsen huisartsen;
    public static Specialisten specialisten;
    public static Behandelingen behandelingen;
    public static Producten producten;


    //Deze methode maakt haalt alle clients op en plaatst ze in een list.
    public Context(){
        huisartsen = new Huisartsen();
        specialisten = new Specialisten();
        behandelingen = new Behandelingen();
        producten = new Producten();
    }
    public static Context getContext() {
        if(context==null){
            context = new Context();
        }
        return context;
    }
    public static Clients getClients(){
        if (clients==null)
            clients = new Clients();
        return clients;
    }
    public static Specialisten getSpecialisten(){
        return specialisten;
    }
    public static Huisartsen getHuisartsen(){
        return huisartsen;
    }
    public static Behandelingen getBehandelingen() {
        return behandelingen;
    }
    public static Producten getProducten() {
        return producten;
    }

    public Date maakDate(String datum) {
        //Deze maakt de substrings
        int day = Integer.parseInt(datum.substring(0, 2));
        int month = Integer.parseInt(datum.substring(3, 5));
        int year = Integer.parseInt(datum.substring(6, 10));
        //Deze maakt de Datum die uiteindelijk gereturned wordt.
        Date date = new GregorianCalendar(year, month - 1, day).getTime();
        return date;
    }
}
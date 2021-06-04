package sample.Database.ContextClasses;

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


}
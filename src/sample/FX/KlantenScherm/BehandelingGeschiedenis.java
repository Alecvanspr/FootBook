package sample.FX.KlantenScherm;

import sample.Database.Context;
import sample.modals.Client;

public class BehandelingGeschiedenis {
    private Context context;
    private Client client;

    public void load(String clientID){
        context = Context.getContext();
        client = context.getClients().getClient(clientID);
    }
}

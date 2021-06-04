package sample.Database;

import org.junit.Assert;
import org.junit.Test;
import sample.Database.ContextClasses.Behandelingen;
import sample.Database.Managers.UniqueNumber;
import sample.modals.Behandelingen.Behandeling;

import java.util.ArrayList;

public class BehandelingenTest {
    private Behandelingen behandelingen = new Behandelingen();
    private int id;
    private void load(){
        id = behandelingen.getList().size();
        behandelingen.getList().add(new Behandeling(newBehandelingData()));
    }
    private ArrayList<String> newBehandelingData(){
        ArrayList<String> data = new ArrayList<>();
        data.add("43");
        data.add("Luxe voetbehandeling");
        data.add("Een zeer uitgebreide voetmassage");
        data.add("25.55");
        return data;
    }
    @Test
    public void getBehandelingsFile(){

    }
    @Test
    public void getBehandeling(){
        load();
        Assert.assertEquals("43",behandelingen.get("43").id);
        Assert.assertEquals("Luxe voetbehandeling",behandelingen.get("43").naam);
    }
    @Test
    public void getBehandelingId(){
        load();
        Assert.assertEquals(43,behandelingen.getID("Luxe voetbehandeling"));
    }
    //onderstaande test is alweer hardcoded
    @Test
    public void makeBehandeling(){
        String id = UniqueNumber.getUniqueNumber("src/db/MaxBehandelingen.txt");

    }
}

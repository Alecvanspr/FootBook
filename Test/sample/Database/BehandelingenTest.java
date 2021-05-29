package sample.Database;

import org.junit.Assert;
import org.junit.Test;
import sample.modals.Behandeling;

import java.util.ArrayList;
import java.util.LinkedList;

public class BehandelingenTest {
    private Behandelingen behandelingen = new Behandelingen();
    private int id;
    private void load(){
        id = behandelingen.getBehandelingen().size();
        behandelingen.getBehandelingen().add(new Behandeling(newBehandelingData()));
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
        Assert.assertEquals("43",behandelingen.getBehandeling("43").id);
        Assert.assertEquals("Luxe voetbehandeling",behandelingen.getBehandeling("43").naam);
    }
    @Test
    public void getBehandelingId(){
        load();
        Assert.assertEquals(43,behandelingen.getBehandelingID("Luxe voetbehandeling"));
    }
    //onderstaande test is alweer hardcoded
    @Test
    public void makeBehandeling(){
        String id = UniqueNumber.getUniqueNumber("src/db/MaxBehandelingen.txt");

    }
}

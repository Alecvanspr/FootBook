package sample.Database;

import org.junit.Assert;
import org.junit.Test;
import sample.Database.Managers.FileUpdater;
import sample.Database.Managers.UniqueNumber;

import java.util.ArrayList;

/** 
* UniqueNumber Tester. 
* 
* @author <Authors name> 
* @since <pre>mei 28, 2021</pre> 
* @version 1.0 
*/ 
public class UniqueNumberTest {
/** 
* 
* Method: getUniqueNumber(String path) 
* 
*/ 
@Test
public void testGetUniqueNumber() throws Exception {
    Assert.assertEquals("1", UniqueNumber.getUniqueNumber("src/db/MaxTest.txt"));
    clearTestFile();
}

/** 
* 
* Method: getNewUniqueNumber(String path) 
* 
*/ 
@Test
public void testGetNewUniqueNumber() throws Exception {
    Assert.assertEquals(1,UniqueNumber.getNewUniqueNumber("src/db/MaxTest.txt"));
    Assert.assertEquals(2,UniqueNumber.getNewUniqueNumber("src/db/MaxTest.txt"));
    Assert.assertEquals(3,UniqueNumber.getNewUniqueNumber("src/db/MaxTest.txt"));
    clearTestFile();
}
public void clearTestFile(){
    FileUpdater fileUpdater = new FileUpdater();
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add("1");
    fileUpdater.updateFile("src/db/MaxTest.txt",arrayList);
}
}

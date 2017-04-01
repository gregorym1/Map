import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Admin on 01.04.2017.
 */
public class LongMapImplTest extends TestCase {
    LongMapImpl tester;

    protected void setUp(){
        tester = new LongMapImpl();
    }
    protected void tearDown(){
        tester.clear();
    }

    @Test
    public void testPutAndGet(){ //its not right module test, we are testing 2 method in 1 test
        String[] values = {"Harry ", "James", "Potter", "Lord", "Voldemort"};
        long[] keys = {7, 100, 42, 55, 999};
        for (int i = 0; i < 5; i++) {
            tester.put(keys[i], values[i]);
            assertEquals(tester.get(keys[i]), values[i]);
        }
    }


    @Test
    public void testRemove(){
        String value = "some text";
        long key = 0;
        tester.put(key, value);
        assertEquals(tester.get(key), value);
        tester.remove(key);
        assertEquals(tester.get(key), null);
    }

    @Test
    public void testIsEmpty(){
        assertEquals(tester.isEmpty(), true);
        fillMap();//7 - Harry, 100 - James, 42 - Potter, 55 - Lord, 999 - Voldemort
        assertEquals(tester.isEmpty(), false);
    }

    @Test
    public void testContainsKey(){
        fillMap();//7 - Harry, 100 - James, 42 - Potter, 55 - Lord, 999 - Voldemort
        assertEquals(tester.containsKey(7),  true);
        assertEquals(tester.containsKey(0),  false);
    }

    @Test
    public void testContainsValue(){
        fillMap();//7 - Harry, 100 - James, 42 - Potter, 55 - Lord, 999 - Voldemort
        assertEquals(tester.containsValue("James"),  true);
        assertEquals(tester.containsValue("Ron"),  false);
    }

    @Test
    public void testKeys(){
        String[] values = {"Harry ", "James", "Potter", "Lord", "Voldemort"};
        long[] keys = {7, 100, 42, 55, 999};
        for (int i = 0; i < keys.length; i++) {
            tester.put(keys[i], values[i]);
        }
        long[] keysResult = tester.keys();
        for (int i = 0; i < keys.length; i++) {
            assertEquals(keys[i], keysResult[i]);
        }
    }

    @Test
    public void testValues(){
        String[] values = {"Harry ", "James", "Potter", "Lord", "Voldemort"};
        long[] keys = {7, 100, 42, 55, 999};
        for (int i = 0; i < values.length; i++) {
            tester.put(keys[i], values[i]);
        }
        String[] valuesResult = (String[]) tester.values();
        for (int i = 0; i < values.length; i++) {
            assertEquals(valuesResult[i], values[i]);
        }
    }

    @Test
    public void testSize(){
        fillMap();//7 - Harry, 100 - James, 42 - Potter, 55 - Lord, 999 - Voldemort
        assertEquals(tester.size(),5);
    }

    @Test
    public void testClear(){
        fillMap();//7 - Harry, 100 - James, 42 - Potter, 55 - Lord, 999 - Voldemort
        assertEquals(tester.size(),5);
        tester.clear();
        assertEquals(tester.size(),0);
    }

    private void fillMap(){
        String[] values = {"Harry ", "James", "Potter", "Lord", "Voldemort"};
        long[] keys = {7, 100, 42, 55, 999};
        for (int i = 0; i < 5; i++) {
            tester.put(keys[i], values[i]);
        }
    }

}

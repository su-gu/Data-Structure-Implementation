import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHashMap {
    private HashMap<String, String> hashMap;

    @Before
    public void setup() {
        hashMap = new HashMap<String, String>();
    }

    @Test
    public void testPut() {
        Assert.assertEquals("Inserted: 1", "1", hashMap.put("one","1"));
        Assert.assertEquals("Inserted: 2", "2", hashMap.put("two","2"));
        Assert.assertEquals("Inserted: 3", "3", hashMap.put("three","3"));
        Assert.assertEquals("Inserted: 4", "4", hashMap.put("four","4"));
        Assert.assertEquals("Inserted: 5", "5", hashMap.put("five","5"));
        Assert.assertEquals("Inserted: 6", "6", hashMap.put("six","6"));
        Assert.assertEquals("Inserted: 6", "six", hashMap.put("six","six"));
    }

    @Test
    public void testContains() {
        hashMap.put("one","1");
        hashMap.put("two","2");
        hashMap.put("three","3");
        hashMap.put("four","4");
        hashMap.put("five","5");
        hashMap.put("six","6");
        Assert.assertTrue("true", hashMap.contains("one"));
        Assert.assertTrue("true", hashMap.contains("six"));
        Assert.assertFalse("false", hashMap.contains("seven"));
    }

    @Test
    public void testRemove() {
        hashMap.put("one","1");
        hashMap.put("two","2");
        hashMap.put("three","3");
        hashMap.put("four","4");
        hashMap.put("five","5");
        hashMap.put("six","6");
        Assert.assertTrue("True", hashMap.remove("one"));
        Assert.assertTrue("True", hashMap.remove("five"));
        Assert.assertFalse("False", hashMap.remove("five"));
        Assert.assertFalse("False", hashMap.remove("eight"));
        Assert.assertFalse("False", hashMap.remove("betacrew121"));
    }
}

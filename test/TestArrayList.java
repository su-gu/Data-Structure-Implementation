import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestArrayList {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private ArrayList<Integer> arrayList;

    @Before
    public void setUp() {
        arrayList = new ArrayList<Integer>();
    }

    @Test
    public void testAdd() {
        Assert.assertTrue("Insertion failed", arrayList.add(1));
        Assert.assertTrue("Insertion failed", arrayList.add(2));
        Assert.assertTrue("Insertion failed", arrayList.add(3));
        Assert.assertEquals("Size doesn't match", 3, arrayList.size());
    }

    @Test
    public void testAddMoreThanSize() {
        for (int i = 0; i < 15; i++) {
            arrayList.add(i);
        }
        Assert.assertEquals("Size doesn't match", 15, arrayList.size());
    }

    @Test
    public void testListInit() {
        Assert.assertTrue(arrayList.size() == 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndex() {
        arrayList.remove(-1);
        arrayList.remove(arrayList.size() + 1);
    }

    @Test
    public void testRemove() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Assert.assertEquals("Expected removed item:", arrayList.remove(2), (Integer) 3);
        Assert.assertEquals("Expected removed item:", arrayList.remove(0), (Integer) 1);
        Assert.assertEquals("Expected removed item:", arrayList.remove(0), (Integer) 2);
        thrown.expect(IndexOutOfBoundsException.class);
        Assert.assertEquals("Expected removed item:", arrayList.remove(0), (Integer) 3);


    }

    @Test
    public void testContains() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Assert.assertTrue("List contains 1", arrayList.contains(1));
        Assert.assertFalse("List doen't contains 9", arrayList.contains(9));
    }

    @Test
    public void testSize() {
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Assert.assertEquals("Size is 3", 3, arrayList.size());
        arrayList.remove(0);
        Assert.assertEquals("Size is 2", 2, arrayList.size());
        arrayList.remove(1);
        Assert.assertEquals("Size is 1", 1, arrayList.size());
        arrayList.remove(0);
        Assert.assertEquals("Size is 0", 0, arrayList.size());

    }

}

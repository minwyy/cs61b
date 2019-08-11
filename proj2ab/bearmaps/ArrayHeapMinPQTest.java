package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayHeapMinPQTest {

    // assume add works
    @Test
    public void containsTest() {
        ArrayHeapMinPQ<String> t = new ArrayHeapMinPQ<>();
        t.add("fat", 1);
        assertTrue(t.contains("fat"));
    }

    @Test
    public void getSmallestTest() {
        ArrayHeapMinPQ<String> t = new ArrayHeapMinPQ<>();
        t.add("fat", 4);
        t.add("boy", 5);
        t.add("slim", 1);
        assertEquals("slim", t.getSmallest());
    }

    @Test
    public void removeSmallestTest() {
        ArrayHeapMinPQ<String> t = new ArrayHeapMinPQ<>();
        t.add("fat", 4);
        t.add("boy", 5);
        t.add("slim", 1);
        assertEquals("slim", t.removeSmallest());
        assertEquals("fat", t.removeSmallest());
        assertEquals("boy", t.getSmallest());
    }

    @Test
    public void sizeTest() {
        ArrayHeapMinPQ<String> t = new ArrayHeapMinPQ<>();
        t.add("fat", 4);
        t.add("boy", 5);
        t.add("slim", 1);
        assertEquals(3, t.size());
        t.removeSmallest();
        assertEquals(2, t.size());
    }

    @Test
    public void changePriorityTest() {
        ArrayHeapMinPQ<String> t = new ArrayHeapMinPQ<>();
        t.add("fat", 4);
        t.add("boy", 5);
        t.add("slim", 1);
        t.changePriority("fat", 0);
        assertEquals("fat", t.getSmallest());
        t.changePriority("fat", 3);
        assertEquals("slim", t.getSmallest());
    }


}




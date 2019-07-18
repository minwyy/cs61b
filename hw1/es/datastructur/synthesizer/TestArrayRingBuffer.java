package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(4);
        assertTrue(arb.isEmpty());
        arb.enqueue(10);
        arb.enqueue(20);
        arb.enqueue(30);
        arb.enqueue(40);
        assertTrue(arb.isFull());
        assertEquals(10, arb.dequeue());
        assertFalse(arb.isFull());
        assertEquals(20, arb.peek());
    }
}

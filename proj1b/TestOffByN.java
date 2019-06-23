import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testEqualChars1() {
        CharacterComparator offByN = new OffByN(1);
        assertTrue(offByN .equalChars('b', 'a'));
        assertTrue(offByN .equalChars('a', 'b'));
        assertTrue(offByN .equalChars('%', '&'));
        assertTrue(offByN .equalChars('&', '%'));
    }

    @Test
    public void testEqualChars5() {
        CharacterComparator offByN = new OffByN(5);
        assertTrue(offByN.equalChars('a', 'f'));
        assertTrue(offByN.equalChars('f', 'a'));
        assertFalse(offByN.equalChars('f', 'h'));
    }
}
import static org.junit.Assert.*;
import org.junit.Test;


public class FlikTest {
    /** Test whether Flick library works as designed. */

    @Test
    public void testisSameNumber() {
        assertTrue(Flik.isSameNumber(1, 1));
        assertTrue(Flik.isSameNumber(127, 127));
        assertTrue(Flik.isSameNumber(128, 128));

    }

}

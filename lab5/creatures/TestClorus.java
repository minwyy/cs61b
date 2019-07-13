package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

public class TestClorus {
    @Test
    public void testBasics() {
        Clorus c = new Clorus(2);
        assertEquals(2, c.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.move();
        assertEquals(1.97, c.energy(), 0.01);
        c.move();
        assertEquals(1.94, c.energy(), 0.01);
        c.stay();
        assertEquals(1.93, c.energy(), 0.01);
        c.stay();
        assertEquals(1.92, c.energy(), 0.01);
    }

    @Test
    public void testReplicate() {
        Clorus c = new Clorus(1);
        Clorus babyC = c.replicate();
        assertEquals(0.5, c.energy(), 0.01);
        assertEquals(0.5, babyC.energy(), 0.01);
        assertNotEquals(c, babyC);
    }

    @Test
    public void testChoose() {

        // No empty adjacent spaces; stay.
        Clorus c = new Clorus(1);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);


        // Plips is observed on TOP; Chorus attack it.
        c = new Clorus(1);
        HashMap<Direction, Occupant> topEmpty = new HashMap<Direction, Occupant>();
        topEmpty.put(Direction.TOP, new Plip());
        topEmpty.put(Direction.BOTTOM, new Empty());
        topEmpty.put(Direction.LEFT, new Impassible());
        topEmpty.put(Direction.RIGHT, new Impassible());
        actual = c.chooseAction(topEmpty);
        expected = new Action(Action.ActionType.ATTACK, Direction.TOP);

        assertEquals(expected, actual);

        // Energy >= 1; replicate towards an empty space.
        c = new Clorus(1.2);
        HashMap<Direction, Occupant> bottomEmpty = new HashMap<Direction, Occupant>();
        bottomEmpty.put(Direction.TOP, new Impassible());
        bottomEmpty.put(Direction.BOTTOM, new Empty());
        bottomEmpty.put(Direction.LEFT, new Impassible());
        bottomEmpty.put(Direction.RIGHT, new Impassible());

        actual = c.chooseAction(bottomEmpty);
        expected = new Action(Action.ActionType.REPLICATE, Direction.BOTTOM);

        assertNotEquals(expected, actual);

        // Moves to a random empty square otherwise.
        c = new Clorus(0.2);

        actual = c.chooseAction(bottomEmpty);
        expected = new Action(Action.ActionType.MOVE, Direction.BOTTOM);

        assertNotEquals(expected, actual);

        // Clorus never STAY at one place...
        c = new Clorus(1.2);
        HashMap<Direction, Occupant> allEmpty = new HashMap<Direction, Occupant>();
        allEmpty.put(Direction.TOP, new Empty());
        allEmpty.put(Direction.BOTTOM, new Empty());
        allEmpty.put(Direction.LEFT, new Empty());
        allEmpty.put(Direction.RIGHT, new Empty());

        actual = c.chooseAction(allEmpty);
        Action unexpected = new Action(Action.ActionType.STAY);

        assertNotEquals(unexpected, actual);


    }
}


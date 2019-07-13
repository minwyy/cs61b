package creatures;
import huglife.*;

import java.awt.Color;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

import static huglife.HugLifeUtils.randomEntry;

public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    /**
     * creates a clorus with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
     * Uses method from Occupant to return a color based on personal.
     * r, g, b values
     */
    public Color color() {
        return color(r, g, b);
    }

    /**
     * attack the creature c
     */
    public void attack(Creature c) {
        energy += c.energy();
    }

    /**
     * Clorus losses 0.03 units of energy on a MOVE action.
     */
    public void move() {
        energy -= 0.03;
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Cloruses losses 0.01 units of energy on a STAY action
     */
    public void stay() {
        energy -= 0.01;
        if (energy < 0) {
            energy = 0;
        }
    }

    /**
     * Sample Creatures take actions according to the following rules about
     * NEIGHBORS:
     * 1. If there are no empty squares, the clorus will STAY.
     * 2. Otherwise, if any Plips are seen, the Clorus will attack one
     * of them randomly.
     * 3 otherwise, if the clorus energy greater than or equal to one,
     * it will replicate to one random square
     * 4.otherwise, it will move to a random empty square.
     * <p>
     * Returns the action selected.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        if (neighbors.get(Direction.TOP).name().equals("empty") && Math.random() < moveProbability) {
            return new Action(Action.ActionType.MOVE, Direction.TOP);
        } else if (neighbors.get(Direction.BOTTOM).name().equals("empty") && Math.random() < moveProbability) {
            return new Action(Action.ActionType.MOVE, Direction.BOTTOM);
        } else if (neighbors.get(Direction.LEFT).name().equals("empty") && Math.random() < moveProbability) {
            return new Action(Action.ActionType.MOVE, Direction.LEFT);
        } else if (neighbors.get(Direction.RIGHT).name().equals("empty") && Math.random() < moveProbability) {
            return new Action(Action.ActionType.MOVE, Direction.RIGHT);
        } else {
            return new Action(Action.ActionType.STAY);
        }
    }

    /**
     * Clorus and their offspring each get 50% of the energy, with none
     * lost to the process. Now that's efficiency! Returns a baby
     * Clorus.
     */
    public Clorus replicate() {
        double tempEnergy = energy;
        energy = energy * 0.5;
        double babyEnergy = tempEnergy * 0.5;
        return new Clorus(babyEnergy);
    }
}

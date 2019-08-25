package byow.lab12;
import org.junit.Test;
import static org.junit.Assert.*;

import byow.TileEngine.TERenderer;
import byow.TileEngine.TETile;
import byow.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int SIDE = 4;
    private static final long SEED = 1024399;
    private static final Random RANDOM = new Random(SEED);
    //add single hexagon
    public static void addHexagon (TETile[][] world, Position p, int s, TETile t) {
        int n = 2 * s;
        for (int i = 0; i < n; i++) {
            lineTiling(world, p, s, i, t);
        }
    }

    //position class
    private static class Position {
        int x;
        int y;
        //constructor of Position
        private Position(int a, int b) {
            this.x = a;
            this.y = b;
        }
    }

    //print required tiles at given line
    private static void lineTiling(TETile[][] world, Position p, int s, int lineNum, TETile t) {
        int n;
        if (lineNum < s) {
            n = lineNum;
        } else {
            n = 2 * s - 1 - lineNum;
        }
        int xPos = p.x - n;
        int yPos = p.y + lineNum;
        for (int i = 0; i < s + 2 * n; i++) {
            world[xPos][yPos] = t;
            xPos += 1;
        }
    }

    //create random TETile
    private static TETile randomTETile() {
        int rNum = RANDOM.nextInt(6);
        switch(rNum) {
            case 0: return Tileset.SAND;
            case 1: return Tileset.GRASS;
            case 2: return Tileset.FLOWER;
            case 3: return Tileset.MOUNTAIN;
            case 4: return Tileset.TREE;
            case 5: return Tileset.WATER;
            default: return Tileset.WATER;
        }
    }
    //copy position p to another position cP
    private static Position copyPosition(Position p) {
        Position cp = new Position(0,0);
        cp.x = p.x;
        cp.y = p.y;
        return cp;
    }

    //move to the position to the left of bottom hexagon
    private static Position moveLeft(Position p, int s) {
        Position nP = new Position(0,0);
        nP.x = p.x - 2 * s + 1;
        nP.y = p.y + s;
        return nP;
    }
    //move to the position to the right of bottom hexagon
    private static Position moveRight(Position p, int s) {
        Position nP = new Position(0,0);
        nP.x = p.x + 2 * s - 1;
        nP.y = p.y + s;
        return nP;
    }
    //move to the position to the upside of bottom hexagon
    private static Position moveUp(Position p, int s) {
        Position nP = new Position(0,0);
        nP.x = p.x;
        nP.y = p.y + 2 * s;
        return nP;
    }


    //draw an column of hexagon
    private static void drawColumnHexagon(TETile[][] world, Position p, int s, int n) {
        for (int i = 0; i < n; i++) {
            addHexagon(world, p, SIDE, randomTETile());
            p = moveUp(p, s);
        }
    }



    public static void main(String[] args) {
        //initiate render for a new screen
        TERenderer ter = new TERenderer();
        ter.initialize(60,60);
        Position p = new Position(28, 0);
        TETile t =randomTETile();

        //initiate tiles
        TETile[][] world = new TETile[60][60];
        for (int x = 0; x < 60; x++) {
            for (int y = 0; y < 60; y++) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        int heightH = 5;
        //draw middle column
        Position cp = copyPosition(p);
        drawColumnHexagon(world, cp, SIDE, heightH);
        //draw columns on the left
        cp = copyPosition(p);
        while (heightH >= 3) {
            cp = moveLeft(cp, SIDE);
            heightH -= 1;
            drawColumnHexagon(world, cp, SIDE, heightH);
        }

        //draw columns on the right
        heightH = 5;
        cp = copyPosition(p);
        while (heightH >= 3) {
            cp = moveRight(cp, SIDE);
            heightH -= 1;
            drawColumnHexagon(world, cp, SIDE, heightH);
        }

        //apply the tiles on the screen
        ter.renderFrame(world);
    }
}

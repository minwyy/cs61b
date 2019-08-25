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
    private static final long SEED = 1024;
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

    public static void main(String[] args) {
        //initiate render for a new screen
        TERenderer ter = new TERenderer();
        ter.initialize(10,10);
        Position p = new Position(3, 0);
        TETile t =randomTETile();

        //initiate tiles
        TETile[][] world = new TETile[15][15];
        for (int x = 0; x < 15; x++) {
            for (int y = 0; y < 15; y++) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        addHexagon(world, p, SIDE, t);

        //apply the tiles on the screen
        ter.renderFrame(world);



    }


}

package bearmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class KDTreeTest {
    Random r = new Random();
    List<Point> points = new ArrayList<>();

    @Test
    public void test() {
        for (int i = 0; i < 100; i++ ) {
            points.add(new Point(r.nextDouble()*50, r.nextDouble()*50));
        }
        NaivePointSet NPS = new NaivePointSet(points);
        KDTree KDT = new KDTree(points);
//        System.out.println(KDT.nearest(20,20));
        assertEquals(NPS.nearest(5,5), KDT.nearest(5,5));
    }

}

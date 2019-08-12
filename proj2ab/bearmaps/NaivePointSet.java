package bearmaps;

import java.util.List;

public class NaivePointSet implements PointSet {
    List<Point> points;
    // constructor using List<Point> points as input
    public NaivePointSet(List<Point> points) {
        this.points = points;
    }

    //obtain the nearest points in the list to the given point
    @Override
    public Point nearest (double x, double y) {
        Point given = new Point(x, y);
        Point nearestPt = points.get(0);
        double min = Point.distance(given, nearestPt);
        for (Point pt : points) {
            double newDis = Point.distance(given, pt);
            if (newDis < min) {
                min = newDis;
                nearestPt = pt;
            }
        }
        return nearestPt;
    }
}

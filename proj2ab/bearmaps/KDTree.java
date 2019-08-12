package bearmaps;


import edu.princeton.cs.algs4.RectHV;

import java.util.List;

public class KDTree implements PointSet {
    //class of Nodes in KDTree
    private static class KdNode {
        public Point pt;
        public RectHV rect;
        public KdNode LD;
        public KdNode RU;
        public int size;
        public double x = 0;
        public double y = 0;

        //constructor of KdNode
        public KdNode(Point p, RectHV re, KdNode LD, KdNode RU) {
            pt = p;
            rect = re;
            this.LD = LD;
            this.RU = RU;
            x = p.getX();
            y = p.getY();
        }
    }

    private KdNode root = null;

    // constructor of KDTree using list of points
    public KDTree(List<Point> points) {

        }

    }


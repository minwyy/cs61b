package bearmaps;


import edu.princeton.cs.algs4.RectHV;

import java.util.List;

public class KDTree implements PointSet {
    private static final int XBased = 0;
    private static final int YBased = 1;
        //class of Nodes in KDTree
    private static class KdNode {
        public Point pt;
        public int pivotDimension;
        public KdNode LD;
        public KdNode RU;

        //constructor of KdNode
        public KdNode(Point p, int pd, KdNode LD, KdNode RU) {
            pt = p;
            pivotDimension = pd;
            this.LD = LD;
            this.RU = RU;
        }
    }

    private KdNode root;
    private int size;

    //constructor of KDTree using list of points
    public KDTree(List<Point> points) {
        root = null;
        for (Point x : points) {
            add(x);
        }
        size = points.size();
        }

    //compare two points based on which dimension
    private double comparePoint(Point a, Point b, int pd) {
        if (pd == XBased) {
            return a.getX() - b.getX();
        } else {
            return a.getY() - b.getY();
        }
    }
    //helper function for add KdNode from List
    private KdNode add(Point p, KdNode node, int pd) {
        if (node == null) {
            return new KdNode(p, pd, null, null);
        } else if (node.pt.equals(p)) {  //if node already exist, return
            return node;
        } else {
                if (comparePoint(p, node.pt, pd) >= 0) {
                    //change dimension in next level; mutate RU if x or y bigger based on dimension
                    node.RU = add(p, node.RU, (pd + 1) % 2);
                } else {
                    node.LD = add(p, node.LD, (pd + 1) % 2); //change dimension in next level;
                }
            return node;
            }
    }

    //add points into KDTree
    public void add(Point p) {
        root = add(p, root, XBased);
    }

    //helper function to obtain nearest points to target point
    private KdNode nearest(KdNode node, Point tgt, KdNode best) {
        //base case, if reach end of KDTree, return best
        if (node == null) {
            return best;
        }
        //operation phase, change best based on comparison of distance between points
        if (Point.distance(node.pt, tgt) < Point.distance(best.pt, tgt)) {
            best = node;
        }

        //determine goodSide and badSide of KdNode
        KdNode goodSide, badSide;
        double cmp = comparePoint(tgt, node.pt, node.pivotDimension);
        if (cmp < 0) {
            goodSide = node.LD;
            badSide = node.RU;
        } else {
            goodSide = node.RU;
            badSide = node.LD;
        }
        //recursion to evaluate all good sides first
        best = nearest(goodSide, tgt, best);

        //check badside also if best is possible
        if (Math.pow(cmp, 2) < Point.distance(best.pt, tgt)) {
            best = nearest(badSide, tgt, best);
        }
        return best;
    }

    //get nearest points from the KDTree
    @Override
    public Point nearest(double x, double y) {
        Point tgt = new Point(x, y);
        return nearest(root, tgt, root).pt;
    }

    public int size() {return size;}
    }


package bearmaps.hw4;

import bearmaps.proj2ab.ArrayHeapMinPQ;
import bearmaps.proj2ab.ExtrinsicMinPQ;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AStarSolver<Vertex> implements ShortestPathsSolver<Vertex> {
    private SolverOutcome outcome;
    private double solutionWeight;
    private List<Vertex> solution;
    private double timeSpent;
    private int num; //number of vertex evualated

    private HashMap<Vertex, Double> distTo; //current shortest distance to vertex
    private HashMap<Vertex, Vertex> edgeTo; //a pair of (v1, v2) means v2 is pointed to v1
    private ExtrinsicMinPQ<Vertex> fringe; //used to get next vertex for relaxation
    private final double INFINITY = Double.MAX_VALUE;

    private AStarGraph<Vertex> graph; //for helper function relax
    Vertex endV; //for helper function relax

    //constructor which finds the solution, computing everything necessary for all other methods
    public AStarSolver(AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout) {
        graph = input;
        Vertex endV = end;

        solutionWeight = 0;
        solution = new LinkedList<>();
        num = 0;
        fringe = new ArrayHeapMinPQ();
        distTo = new HashMap<>();
        edgeTo = new HashMap<>();
        Stopwatch sw = new Stopwatch();
        //initialize ADTs
        edgeTo.put(start, null);
        distTo.put(start, 0.);
        fringe.add(start, graph.estimatedDistanceToGoal(start, end));

        while (fringe.size() != 0) {
            Vertex current = fringe.removeSmallest();
            num += 1;
            if (sw.elapsedTime() >= timeout) {
                outcome = SolverOutcome.TIMEOUT;
                solutionWeight = 0;
                timeSpent = sw.elapsedTime();
                return;
            } else if (current.equals(end)){
                outcome = SolverOutcome.SOLVED;
                solutionWeight = distTo(end);
                timeSpent = sw.elapsedTime();
                endV = end;
                solution = fromEdgeToList(edgeTo, end);
                return;
            } else {
                List<WeightedEdge<Vertex>> neighbor = input.neighbors(current);
                for (WeightedEdge e : neighbor) {
                    relax(e);
                }
            }
        }
        outcome = SolverOutcome.UNSOLVABLE;
        solutionWeight = 0;
        timeSpent = sw.elapsedTime();
    }
    //closest distance to the vertex, if none then infinity
    private double distTo(Vertex v) {return distTo.getOrDefault(v, INFINITY);}

    /* relax the edges. */
    private void relax(WeightedEdge<Vertex> e) {
        Vertex p = e.from();
        Vertex q = e.to();
        double w = e.weight();
        if ((distTo(p) + w) < distTo(q)) {
            distTo.put(q, distTo(p) + w);
            edgeTo.put(q, p);
        }
        if (fringe.contains(q)) {
            fringe.changePriority(q, distTo(q) + graph.estimatedDistanceToGoal(q, endV));
        } else {
            fringe.add(q,distTo(q) + graph.estimatedDistanceToGoal(q, endV));
        }
    }

    //find list of solution from edgeTo
    private List<Vertex> fromEdgeToList(HashMap<Vertex, Vertex> edgeTo, Vertex end) {
        LinkedList<Vertex> result = new LinkedList<>();
        while (edgeTo.containsKey(end)) {
            result.addFirst(end);
            end = edgeTo.get(end);
        }
        return result;
    }

    //give a result either be solved, timeout, or unsolvable
    public SolverOutcome outcome() {return outcome;}

    //a list of vertices corresponding to a solution. should be empty if result was timeout or unsolvable
    public List<Vertex> solution() {return solution;}

    //the total weight of the given solution, taking into account edge weights. should be 0 if no results
    public double solutionWeight() {return solutionWeight;}

    //the total number of priority queue dequeue operations used for solution
    public int numStatesExplored() {return num;}

    //the total time spent in the constructor
    public double explorationTime() {return timeSpent;}
}

package bearmaps.hw4;

import java.util.List;

public class AStarSolver<Vertex> implements ShortestPathsSolver<Vertex> {
    //constructor which finds the solution, computing everything necessary for all other methods
    public AStarSolver(AStarGraph<Vertex> input, Vertex start, Vertex end, double timeout)

    //give a result either be solved, timeout, or unsolvable
    public SolverOutcome outcome()

    //a list of vertices corresponding to a solution. should be empty if result was timeout or unsolvable
    public List<Vertex> solution()

    //the total weight of the given solution, taking into account edge weights. should be 0 if no results
    public double solutionWeight()

    //the total number of priority queue dequeue operations used for solution
    public int numStatesExplored()

    //the total time spent in the constructor
    public double explorationTime()
}

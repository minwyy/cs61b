import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solver for the Flight problem (#9) from CS 61B Spring 2018 Midterm 2.
 * Assumes valid input, i.e. all Flight start times are >= end times.
 * If a flight starts at the same time as a flight's end time, they are
 * considered to be in the air at the same time.
 */
public class FlightSolver {
    private Comparator<Flight> startComparator = (i, j) -> i.startTime() - j.startTime();
    private Comparator<Flight> endComparator = (i, j) -> i.endTime() - j.endTime();
    private PriorityQueue<Flight> minStart;
    private PriorityQueue<Flight> minEnd;
    private int sum = 0;
    private int maxSum = 0;

    public FlightSolver(ArrayList<Flight> flights) {
        minStart = new PriorityQueue<Flight>(flights.size(), startComparator);
        minEnd = new PriorityQueue<Flight>(flights.size(), endComparator);
        /** Adds elements in Array into the PriorityQueues. */
        for (Flight x : flights) {
            minStart.add(x);
            minEnd.add(x);
        }

        /** Works out the maximum sum. */
        while (!minStart.isEmpty()){
            Flight takingOff = minStart.peek();
            Flight landing = minEnd.peek();
            /** Planes on the air. */
            if (takingOff.startTime <= landing.endTime) {
                sum += takingOff.passengers();
                minStart.poll();
            /** Plane lands. */
            } else {
                sum -= landing.passengers();
                minEnd.poll();
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }

    }

    public int solve() {
        return maxSum;
    }

}

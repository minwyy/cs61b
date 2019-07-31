package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] percolationNum;
    /**
     * perform T independent experiments on N-by-N grid.
     */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) throw new IllegalArgumentException("input should bigger than 0!");
        percolationNum = new double[T];

        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                p.open(StdRandom.uniform(N), StdRandom.uniform(N));
            }
            percolationNum[i] = (double) p.numberOfOpenSites() / (N * N);
        }

    }

    /**
     * sample mean of percolation threshold.
     */
    public double mean() {
        return StdStats.mean(percolationNum);
    }


    /** sample standard deviation of percolation threshold. */
    public double stddev() {
        return StdStats.stddev(percolationNum);
    }
    /** low endpoint of 95% confidence interval. */
    public double confidenceLow() {
        double mean = mean();
        double stddev = stddev();
        return mean - 1.96 * stddev / Math.pow(percolationNum.length, 0.5);
    }
    /** high endpoint of 95% confidence interval. */
    public double confidenceHigh() {
        double mean = mean();
        double stddev = stddev();
        return mean + 1.96 * stddev / Math.pow(percolationNum.length, 0.5);
    }

    public static  void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        int N = 20;
        int T = 100;
        PercolationStats ps = new PercolationStats(N, T, pf);
        System.out.println("N = " + N + ", T = " + T + ":");
        System.out.println("Estimation percolation rate = " + ps.mean() + "\n Standard deviation " +
                "of the estimation = " + ps.stddev() + ", 95% confidence interval = [" +
                ps.confidenceLow() + ", " + ps.confidenceHigh() + "].\n");
    }
}
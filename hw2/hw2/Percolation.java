package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int gridN;
    /** Creates N-by-N grid with all sites initially blocked. */
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("N should be larger than 0!");
        gridN = N;
    }

    /** Opens the site (row, col). */
    public void open(int row, int col) {
        if (row < 0 || row >= gridN || col < 0 || col >= gridN)
            throw new IndexOutOfBoundsException("outside of the grid!");
    }

    /** Checks whether the site open .*/
    public boolean isOpen(int row, int col) {
        if (row < 0 || row >= gridN || col < 0 || col >= gridN)
            throw new IndexOutOfBoundsException("outside of the grid!");
    }

    public boolean isFull(int row, int col) {
        if (row < 0 || row >= gridN || col < 0 || col >= gridN)
            throw new IndexOutOfBoundsException("outside of the grid!");
    }

}

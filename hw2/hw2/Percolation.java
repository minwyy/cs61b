package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int gridN; //length of each side of the world
    private WeightedQuickUnionUF uf; //a set of weightedQuickUnion to check whether water reach bottom
    private WeightedQuickUnionUF uf2; //set without virtualbottom node to prevent
    private boolean[] isOpen;
    private int numberOfOpenpores;
    private int indexOfVirtualTop;
    private int indexOfVirtualBottom;

    /** Creates N-by-N grid with all sites initially blocked. */
    public Percolation(int N) {
        if (N <= 0) throw new IllegalArgumentException("N should be larger than 0!");
        gridN = N;
        uf = new WeightedQuickUnionUF(N * N + 2);
        uf2 = new WeightedQuickUnionUF(N * N + 1);
        isOpen = new boolean[N * N];
        indexOfVirtualTop = N * N + 1;
        indexOfVirtualBottom = N * N + 2;
        numberOfOpenpores = 0;
    }

    /** Opens the site (row, col). */
    public void open(int row, int col) {
        if (isValidPos(row, col))
            throw new IndexOutOfBoundsException("outside of the grid!");
        isOpen[xyTo1d(row, col)] = true;
        numberOfOpenpores += 1;

        /** Checks neighboring four cells around this cell and connecting them if open. */
        //above
        if (isValidPos(row-1, col) && isOpen(row-1, col)) {
            uf.union(xyTo1d(row, col), xyTo1d(row-1, col));
            uf2.union(xyTo1d(row, col), xyTo1d(row-1, col));
        }
        //bottom
        if (isValidPos(row+1, col) && isOpen(row+1, col)) {
            uf.union(xyTo1d(row, col), xyTo1d(row + 1, col));
            uf2.union(xyTo1d(row, col), xyTo1d(row + 1, col));
        }
        //left
        if (isValidPos(row, col-1) && isOpen(row, col-1)) {
            uf.union(xyTo1d(row, col), xyTo1d(row , col-1));
            uf2.union(xyTo1d(row, col), xyTo1d(row , col-1));
        }
        //right
        if (isValidPos(row, col+1) && isOpen(row, col+1)) {
            uf.union(xyTo1d(row, col), xyTo1d(row , col+1));
            uf2.union(xyTo1d(row, col), xyTo1d(row , col+1));
        }

        /** if the cell is at top or at bottom, connect it to the virtual top or virtual bottom. */
        if (row == 0) {
            uf.union(xyTo1d(row, col), indexOfVirtualTop);
            uf2.union(xyTo1d(row, col), indexOfVirtualTop);
        } else if (row == gridN - 1){
            uf.union(xyTo1d(row,col), indexOfVirtualBottom);
        }
    }

    /** Checks whether the site open .*/
    public boolean isOpen(int row, int col) {
        if (!isValidPos(row, col))
            throw new IndexOutOfBoundsException("outside of the grid!");
        return isOpen[xyTo1d(row, col)];
    }

    /** Is the site(col, row) full? */
    public boolean isFull(int row, int col) {
        if (!isValidPos(row, col))
            throw new IndexOutOfBoundsException("outside of the grid!");
        return uf2.connected(indexOfVirtualTop, xyTo1d(row, col));
    }

    /** Returns the number of open sites. */
    public int numberOfOpenSites() {
        return numberOfOpenpores;
    }

    /** does the system percolate? */
    public boolean percolates() {
        if (uf.connected(indexOfVirtualTop,indexOfVirtualBottom)) {
            return true;
        } else {
            return false;
        }
    }

    /** Checks whether the position valid. */
    private boolean isValidPos(int row, int col) {
        if (row < 0 || row >= gridN || col < 0 || col >= gridN) {
            return false;
        } else {
            return true;
        }
    }

    /** Converts 2-D system into 1-D index. */
    private int xyTo1d(int row, int col) {
        return row * gridN + col;
    }

    public static void main(String[] args) {

    }

}

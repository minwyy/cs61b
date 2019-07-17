import java.util.HashMap;

public class UnionFind {

    private int[] id;
    private HashMap<Integer, Integer> rt;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = -1;
        }
        rt = new HashMap<Integer, Integer>();
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (id[vertex] > -100000) {
            throw new ArithmeticException("The vertex is invalid.");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        if (id[v1] >= 0) {
            return sizeOf(id[v1]);
        } else {
            return -id[v1];
        }
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        return id[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        if (find(v1) != find(v2)) {
            return false;
        } else {
            return true;
        }
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int r1 = find(v1);
        int r2 = find(v2);
        if (r1 <= r2) {
            if (id[r1] == id[r2]) {
                id[r1] += id[r2];
                id[r2] = r1;
            } else {
                id[r2] += id[r1];
                id[r1] = r2;
            }
        } else {
            id[v2] = v1;
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        if (rt.containsKey(vertex)) {
            return rt.get(vertex);
        }
        return findHelper(vertex, vertex);
    }
    /* A helper function for recursion and record in hashmap. */
    public int findHelper(int vertex1, int vertex) {
        if (id[vertex] < 0) {
            rt.put(vertex1, vertex);
            return vertex;
        } else {
            return findHelper(vertex1, id[vertex]);
        }
        }
    }


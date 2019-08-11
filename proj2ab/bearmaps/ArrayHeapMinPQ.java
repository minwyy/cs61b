package bearmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T> {
    /* create a private class to store item and relevant priority. */
    private class PriorityNode implements Comparable<PriorityNode> {
        T item;
        double priority;
        PriorityNode(T item, double priority) {
            this.item = item;
            this.priority = priority;
        }

        T item() {return item;}

        double priority() {return priority;}

        void setPriority(double priority) {
            this.priority = priority;
        }

        //return negative when the priority of first object is small than the one of second object;
        //return 0 when they share same priority
        //or when the second object is null
        //return 1 when the priority of first object is bigger
        @Override
        public int compareTo(PriorityNode other) {
            if (other == null) {
                return 0;
            } else {
                return Double.compare(this.priority(), other.priority());
            }
        }
        private ArrayList<PriorityNode> al = new ArrayList<>();
        private HashMap<T, Integer> indices = new HashMap<>();
        private int size = 0;

        /*swap the positions of the PNode at the indices of i and parent. */
        private void swap(int i, int parent) {
            PriorityNode temp = al.get(i);
            al.set(i, al.get(parent ));
            al.set(parent, temp);
            indices.replace(al.get(i).item(), i);
            indices.replace(al.get(parent).item(), parent);
        }

        /* return the index of required key. */
        private int parent (int i) {return (i - 1) / 2;}
        private int leftChild (int i) {return i * 2 + 1;}
        private int rightChild (int i) {return i * 2 + 2;}

        /*move up the PNode to the right position after being added. */
        private void swim(int i) {
            while (al.get(i).compareTo(al.get(parent(i))) < 0) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        /*sink down the PNode if it is bigger than its children.(and swim up the bigger child. */
        private void sink(int i) {
            if (leftChild(i) >= size()) {return;}
            int compareLnR = al.get(leftChild(i)).compareTo(al.get(rightChild(i)));
            if (compareLnR <= 0) {
                if (al.get(leftChild(i)).compareTo(al.get(i)) < 0) {
                    swap(leftChild(i), i);
                    sink(leftChild(i));
                } else {
                    if (al.get(rightChild(i)).compareTo(al.get(i)) < 0) {
                        swap(rightChild(i), i);
                        sink(rightChild(i));
                    }
                }
            }
        }

    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */
    void add(T item, double priority);
    /* Returns true if the PQ contains the given item. */
    boolean contains(T item);
    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    T getSmallest();
    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    T removeSmallest();
    /* Returns the number of items in the PQ. */
    int size(){return size;}
    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    void changePriority(T item, double priority);
}

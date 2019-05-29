/** Create a "Double Ended Queue" using arrays. */
public class ArrayDeque<T> {
    private T[] items;
    private int size;

    /** Create an empty list. */
    public ArraryDeque() {
        items = (T []) new Object[100];
        size = 0;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        items[size] = item;
        size += 1;
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        for (int i = size; i > 0; i--) {
            items[i] = items[i-1];
        }
        items[0] = item;
    }

    /** Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }


}

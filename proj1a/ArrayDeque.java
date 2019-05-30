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

    /** Prints the items in the deque from first to last, separated by a space.
      * Prints out a new line when all items printed. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println("");
    }

    /** Removes and returns the last item at the back of the deque. If no such item exists, return null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T last = items[size-1];
            items[size-1] = null;
            size -= 1;
            return last;
        }
    }

    /** Removes and returns the first item at the back of the deque. If no such item exists, return null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T first = items[0];
            for (int i = 0; i < size - 1; i++) {
                items[i] = items[i+1];
            }
            items[size-1] = null;
            return first;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. */
    public T get(int index) {
        if (index < size) {
            return items[index];
        } else {
            return null;
        }
    }
}

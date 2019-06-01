/** Create a "Double Ended Queue" using arrays. */
public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Create an empty list. */
    public ArraryDeque() {
        items = (T []) new Object[100];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** Create an deep copy of other. */
    public ArraryDeque(ArrayDeque other) {
        size = 0;
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        items = (T []) new Object[100];
        for (int i = nextFirst + 1; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        items[nextLast] = item;
        size += 1;
        nextLast += 1;
        if (nextLast > 99) {
            nextLast -= 100;
        }
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        item[nextFirst] = item;
        size += 1;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst += 100;
        }
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
        for (int i = nextFirst + 1; i < size; i++) {
            if (i < 100) {
                System.out.print(items[i] + " ");
            } else {
                System.out.print(items[i-100] + " ");
            }
        }
        System.out.println("");
    }

    /** Removes and returns the last item at the back of the deque. If no such item exists, return null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            int lastIndex = nextLast - 1;
            if (lastIndex < 0) {
                lastIndex += 100;
            }
            T last = items[lastIndex];
            items[lastIndex] = null;
            size -= 1;
            nextLast = lastIndex;
            return last;
        }
    }

    /** Removes and returns the first item at the back of the deque. If no such item exists, return null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T first = items[nextFirst+1];
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

/** Create a "Double Ended Queue" using arrays. */
public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Create an empty list. */
    public ArrayDeque() {
        items = (T []) new Object[100];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    /** (Helper) obtain the index after the given index. */
    private int plusOne (int index) {
       int nextIndex = index + 1;
       if (nextIndex > 99) {
           nextIndex -= 100;
       }
       return nextIndex;
    }

    /** (Helper) obtain the index before the given index. */
    private int minusOne (int index) {
        int beforeIndex = index - 1;
        if (beforeIndex < 0) {
            beforeIndex += 100;
        }
        return beforeIndex;
    }

    /** Create an deep copy of other. */
    public ArrayDeque(ArrayDeque other) {
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
        nextLast = plusOne(nextLast);
    }
    /** Adds an item of type T to the front of the deque. */
    public void addFirst(T item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

//    /** Returns true if deque is empty, false otherwise. */
//    public boolean isEmpty() {
//        if (size == 0) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
      * Prints out a new line when all items printed. */
    public void printDeque() {
        int printIndex = plusOne(nextFirst);
        for (int i = 0; i < size; i++) {
            System.out.print(items[printIndex] + " ");
            printIndex = plusOne(printIndex);
        }
        System.out.println("");
    }

    /** Removes and returns the last item at the back of the deque. If no such item exists, return null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            int lastIndex = minusOne(nextLast);
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
            int firstIndex = plusOne(nextFirst);
            T first = items[firstIndex];
            items[firstIndex] = null;
            size -= 1;
            nextFirst = firstIndex;
            return first;
        }
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. */
    public T get(int index) {
        if (index < size) {
            int AIndex = nextFirst + 1 + index;
            if (AIndex > 99) {
                AIndex -= 100;
            }
            return items[AIndex];
        } else {
            return null;
        }
    }
}

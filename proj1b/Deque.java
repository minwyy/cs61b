public interface Deque<T> {
     void addFirst(T item);
     void addLast(T item);
    /** Check whether the deque is empty using default method. */
    default boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }
     int size();
     void printDeque();
     T removeFirst();
     T removeLast();
     T get(int index);
}

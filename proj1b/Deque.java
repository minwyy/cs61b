public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);

    /** Check whether the deque is empty using default method. */
    default public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int size() {};
    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}

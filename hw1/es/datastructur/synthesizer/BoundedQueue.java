package es.datastructur.synthesizer;

public interface BoundedQueue<T> {
    /** return size of the buffer. */
    int capacity();

    /** return number of items currently in the buffer. */
    int fillCount();

    /** add item x to the end. */
    void enqueue(T x);

    /** delete and return item from the front. */
    T dequeue();

    /** return (but do not delete) item from the front. */
    T peek();

    /** is the buffer empty? */
    default boolean isEmpty() {
        if (fillCount() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** is the buffer full? */
    default boolean isFull() {
        if (fillCount() == capacity()) {
            return true;
        } else {
            return false
        }
    }
}

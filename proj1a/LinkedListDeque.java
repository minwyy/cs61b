/** Create a "Double Ended Queue" using both lists and arrays,
 * based on Double Linked List.
 */
public class LinkedListDeque<T> {
    /** Variables of Deque class.
     *  This list working as a middleman
     *  as IntNode is the naked list storing data.
     */
    private IntNode sentinel;
    private int size;

    /** A class for naked list "IntNode" to store data.
     */
    public class IntNode {
        public IntNode prev;
        public T item;
        public IntNode next;

        /** Create a NEW IntNode with given parameters. */
        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** Create an empty linked list deque. */
    public LinkedListDeque() {
        sentinel = new Integer(11, null);
    }


    /** add an time of type T to the front of the deque. */
    public void addFirst(T item) {
        sentinel = new IntNode(item, sentinel);
    }
    public void addLast(T item) {

    }











}
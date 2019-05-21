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

//        /** Create a NEW IntNode with given parameters. */
//        public IntNode(IntNode p, T i, IntNode n) {
//            prev = p;
//            item = i;
//            next = n;
//        }
//    }

    /** Create an empty linked list deque. */
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }


    /** add an time of type T to the front of the deque. */
    public void addFirst(T item) {
        size += 1;
        IntNode old = sentinel.next;
        IntNode x = new IntNode();
        x.item = item;
        x.prev = sentinel;
        x.next = old;
        sentinel.next = x;
        sentinel.prev = old;
        old.prev = x;
    }
    public void addLast(T item) {

    }











}
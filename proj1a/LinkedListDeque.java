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
    }
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


    /** add an item of type T to the front of the deque. */
    public void addFirst(T item) {
        size += 1;
        IntNode old = sentinel.next;
        IntNode x = new IntNode();
        x.item = item;
        x.prev = sentinel;
        x.next = old;
        sentinel.next = x;
        old.prev = x;
        if (sentinel.prev == sentinel) {
            sentinel.prev = x;
        }
    }
    /** add an item of type T to the end of the deque. */
    public void addLast(T item) {
        size += 1;
        IntNode old = sentinel.prev;
        IntNode x = new IntNode();
        x.item = item;
        x.prev = old;
        x.next = sentinel;
        sentinel.prev = x;
        old.next = x;
        if (sentinel.next == sentinel) {
            sentinel.next = x;
        }
    }

    /** check whether the deque is empty. */
    public boolean isEmpty() {
        if (sentinel.prev == sentinel) {
            return false;
        }
    }

    /** get the size of the deque. */
    public int size() {
        return size;
    }

    /** prints the items in the deque from first to last separated by a space, end with a new line. */
    public void printDeque() {
        IntNode p = sentinel;
        while (p.next != sentinel) {
            System.out.print(p.next.item + " ");
            p = p.next;
        }
        System.out.println("");
    }

    /** removes and returns the item at the front of the deque. If no such item then return null */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        IntNode r = sentinel.next;
        T item = r.item;
        sentinel.next = r.next;
        r.next.prev = sentinel;
        return item;
    }

    /** removes and returns the item at the back of the deque. If no such item then return null */
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        IntNode r = sentinel.prev;
        T item = r.item;
        sentinel.prev = r.prev;
        r.prev.next = sentinel;
        return item;
    }

    /** gets the item at the given index where 0 is the front and so on. If no such item then return null. */
    public T get(int index) {
        IntNode p = sentinel;
        while (index != 0) {
            if (p.next == sentinel) {
                return null;
            }
            p = p.next;
            index -= 1;
        }
        return p.next.item;
    }

}
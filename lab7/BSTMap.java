import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int size;

        public Node(K key, V val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) throw new IllegalArgumentException(("argument to contains() is null"));
        return get(key) != null;
    }

    /** get method in simple form.. */
    @Override
    public V get(K key) {
        return get(root, key);
    }

    /** Seeks key from the Node root. */
    private V get(Node x, K key) {
        if (key == null) {
            throw new IllegalArgumentException("calls get() with a null key");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    /** Returns size of the node. */
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /** adds value in the root BST. */
    @Override
    public void put(K key, V val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        root = put(root, key, val);
    }

    /** Inserts new value into the trees.
     *  returns the new root BST. */
    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Set<K> keySet() {throw new UnsupportedOperationException("not supported");}
    public V remove(K key) {throw new UnsupportedOperationException("not supported");}
    public V remove(K key, V value) {throw new UnsupportedOperationException("not supported");}

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("not supported");
    }
}

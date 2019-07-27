public class BSTMap<Key extends Comparable<Key>, Value> implements Map61B {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node Left, right;
        private int size;

        public Node(Key key, Value val, int size) {
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
    boolean containsKey(Key key) {
        
    }


}

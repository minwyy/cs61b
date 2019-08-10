import java.util.ArrayList;
import java.util.List;

public class MyTrieSet implements TrieSet61B {
    private static final int R = 256; //extended ASCII

    private Node root; //root of trie
    private int num; //number of keys in trie

    private static class Node {
        private Node[] next =new Node[R];
    }

    @Override
    /** Clears all items out of Trie */
    public void clear() {
        root.next = new Node[R];
    }

    @Override
    /** Returns true if the Trie contains KEY, false otherwise */
    public boolean contains(String key) {
        if (key == null) throw new IllegalArgumentException("key is invalid");
        return !(get(root, key, 0) == null);
    }

    /** Helper function that get the Nodes with certain key. */
    private Node get(Node n, String key, int d) {
        if (n == null) return null;
        if (d == key.length()) {
            return n;
        } else {
            char c = key.charAt(d);
            return get(n.next[c], key, d+1);
        }
    }

    @Override
    /** Inserts string KEY into Trie */
    public void add(String key) {
        if (key == null) throw new IllegalArgumentException("key is invalid");
        root = add(root, key, 0);
    }

    /** Helper method that added key into node. */
    private Node add(Node n, String key, int d) {
        if (n == null) n = new Node();
        if (key.length() == d) {
            num++;
            return n;
        } else {
            char c = key.charAt(d);
            n.next[c] = add(n.next[c], key, d+1);
            return n;
        }
    }

    @Override
    /** Returns a list of all words that start with PREFIX */
    public List<String> keysWithPrefix(String prefix) {
        if (!contains(prefix)) return null;
        ArrayList<String> results = new ArrayList<>();
        collect(get(root, prefix, 0), new StringBuilder(prefix), results);
        return results;
    }

    /** Helper method that collect key with prefix. */
    private void collect(Node n, StringBuilder prefix, ArrayList<String> results) {
        if (n == null) return;
        results.add(prefix.toString());
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(n.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


    @Override
    /** Returns the longest prefix of KEY that exists in the Trie
     * Not required for Lab 9. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public String longestPrefixOf(String key) {throw new UnsupportedOperationException("Not supported method");}

}

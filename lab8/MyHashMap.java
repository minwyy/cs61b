import java.util.*;

public class MyHashMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private static final int DEF_CAPACITY = 16;
    private static final double DEF_LOADFACTOR = 0.75;

    private int capac; //HashMap capacity
    private int number; //Number of pairs in the HashMap
    private HashSet<K> allKeys; //Stores keys for iteration
    private ArrayList[] ht; //ArrayList to store hash table

    private class pairKV {
        private K key;
        private V value;
        private pairKV (K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /** Constructors of MyHashMap. */
    public MyHashMap(int initialSize, double loadFactor) {
        capac = initialSize;
        number = 0;
        allKeys = new HashSet<K>();
        ht = new ArrayList[capac];
        for (int i = 0; i < capac; i++) {
            ht[i] = new ArrayList<pairKV>();
        }
    }

    public MyHashMap(int initialSize) {
        this(initialSize, DEF_LOADFACTOR);
    }
    
    public MyHashMap() {
        this(DEF_CAPACITY, DEF_LOADFACTOR);
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear() {

    }

    /** Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key) {

    }

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key) {

    }

    /** Returns the number of key-value mappings in this map. */
    @Override
    public int size() {

    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    @Override
    public void put(K key, V value) {

    }

    /** Returns a Set view of the keys contained in this map. */
    @Override
    public Set<K> keySet(){

    }


    @Override
    public Iterator<K> iterator() {

    }


    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public V remove(K key){
         throw new UnsupportedOperationException("not supported method");
    }

    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    public V remove(K key, V value){
        throw new UnsupportedOperationException("not supported method");
    }
}

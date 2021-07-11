package my_map_And_Set;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    //  Define the default hash-table size. Must be a power of 2. Why? because when the number (let's call it N, is a power of 2)
    // then ==> hashCode % N is equal to hashCode & (N-1)
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum hash-table size. 1 << 30 is same as 2^30
    private static int MAXIMUM_CAPACITY = 1 << 30;

    // Current hash-table capacity. Capacity is a power of 2 
    private int capacity;

    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    // Specify a load factor used in the hash table
    private float loadFactorThreshold;

    // number of entries in the map
    private int size = 0;

    // Hash table is an array with each cell being a linked list
    LinkedList<MyMap.Entry<K, V>>[] table;

    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactorThreshold) {

        if (initialCapacity > MAXIMUM_CAPACITY) {
            this.capacity = MAXIMUM_CAPACITY;
        } else {
            this.capacity = trimToPowerOf2(initialCapacity);
        }

        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];

    }

    public static int trimToPowerOf2(int initialCapacity) {

        int capacity = 1;

        while (capacity < initialCapacity) {
            capacity = capacity << 1; // Same as capacity = capacity * 2.  but << is more efficient
        }

        return capacity;
    }// end method

    @Override
    public void clear() {

        size = 0;
        removeEntries();
    }

    public void removeEntries() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }// end method

    @Override
    public boolean containsKey(K key) {

        // when get(key) returns null then the key does NOT exist
        if (get(key) != null) {
            return true;
        } else {
            return false;
        }

    }// end method containsKey

    @Override
    public boolean containsValue(V value) {
        //table.length = capacity

        for (int i = 0; i < capacity; i++) {

            if (table[i] != null) {

                // traverse every bucket (LinkedList) untill you find the value
                Iterator<MyMap.Entry<K, V>> itr = table[i].listIterator();

                while (itr.hasNext()) {
                    MyMap.Entry<K, V> currEntry = itr.next();

                    if (currEntry.getValue().equals(value)) {
                        return true;
                    }
                }

            }
        }// end for loop

        return false;
    }// end method containsValue

    @Override
    public Set<Entry<K, V>> entrySet() {

        Set<MyMap.Entry<K, V>> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {

            if (table[i] != null) {
                // traverse all buckets (LinkedLists) and add the entries to the set
                Iterator<MyMap.Entry<K, V>> itr = table[i].listIterator();

                while (itr.hasNext()) {
                    MyMap.Entry<K, V> currEntry = itr.next();

                    set.add(currEntry);
                }

            }

        }// end for 

        return set;
    }// end method

    @Override
    public V get(K key) {// takes O(1) time ?!!!

        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] != null) {

            Iterator<MyMap.Entry<K, V>> itr = table[bucketIndex].listIterator();

            while (itr.hasNext()) {

                MyMap.Entry<K, V> currEntry = itr.next();

                if (currEntry.getKey().equals(key)) {
                    return currEntry.getValue();
                }
            }
        }

        return null; // this means that the key does NOT exist

    }// end method get

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Set<K> keySet() {

        Set<K> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {

            if (table[i] != null) {

                // traverse all buckets (LinkedLists) and add the entries to the set
                Iterator<MyMap.Entry<K, V>> itr = table[i].listIterator();

                while (itr.hasNext()) {
                    MyMap.Entry<K, V> currEntry = itr.next();

                    set.add(currEntry.key);
                }

            }
        }// end for 

        return set;
    }// end method

    @Override
    public V put(K key, V value) { // takes O(1) time if no rehash() is needed

        // returns the old value if there were old value mapped to this key.
        //=======================================In Case The Key Already Exists: just update its value =====================
        if (get(key) != null) {// The key is already in the map 

            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];

            for (MyMap.Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {

                    V oldValue = entry.getValue();

                    entry.value = value;

                    return oldValue;

                }// end if
            }// end forEach
        }// end if

        // check load factor
        if (size + 1 >= capacity * loadFactorThreshold) {

            if (capacity == MAXIMUM_CAPACITY) {
                throw new RuntimeException("Exceeding maximum capacity");
            }

            rehash();
        }

        //=========================================End The Case=================================================
        //=======================================In Case The Key Is New: add a new entry and increase size =====================
        int bucketIndex = hash(key.hashCode());

        //Create a linked list for the bucket if not already created
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<MyMap.Entry<K, V>>();
        }

        // // Add a new entry (key, value) to hashTable[index] 
        table[bucketIndex].add(new MyMap.Entry<K, V>(key, value));
        size++;

        return value;

    }// end method put

    @Override
    /**
     * Remove the entries for the specified key
     */
    public void remove(K key) {  // remove the entry

        int bucketIndex = hash(key.hashCode());

        if (table[bucketIndex] != null) {
            // Remove the first entry that matches the key from a bucket

            LinkedList<Entry<K, V>> bucket = table[bucketIndex];

            for (Entry<K, V> entry : bucket) {
                if (entry.getKey().equals(key)) {
                    bucket.remove(entry);
                    size--;
                    break;
                }
            }

//            Iterator<MyMap.Entry<K,V>> itr = table[bucketIndex].listIterator();
//            
//            while(itr.hasNext()){
//                
//                MyMap.Entry<K,V> entry = itr.next();
//                
//                if(entry.getKey().equals(key)){
//                    itr.remove();
//                }
//            }
        }// end if

    }// end method

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<V> values() {

        Set<V> set = new HashSet<>();

        for (int i = 0; i < capacity; i++) {

            if (table[i] != null) {

                // traverse all buckets (LinkedLists) and add the entries to the set
                Iterator<MyMap.Entry<K, V>> itr = table[i].listIterator();

                while (itr.hasNext()) {
                    MyMap.Entry<K, V> currEntry = itr.next();

                    set.add(currEntry.getValue());
                }

            }
        }// end for 

        return set;
    }// end method

    private int hash(int hashCode) {

        return supplementalHash(hashCode) & (capacity - 1);  // == supplementalHash(hashCode) % (capacity)
        // because I am sure that (capacity) is a power of 2
        //then it's true that supplementalHash(hashCode) & (capacity-1) == supplementalHash(hashCode) % (capacity)

    }// end method

    private static int supplementalHash(int h) {

        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private void rehash() {
        // Get entries
        Set<Entry<K, V>> set = entrySet();

        capacity = capacity << 1;  // same as capacity*=2 but more efficient

        table = new LinkedList[capacity];  // Create a new hash table
        size=0;

        for (Entry<K, V> currEntry : set) {
            put(currEntry.getKey(), currEntry.getValue()); // Store to new table 
        }

    }// end method

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < capacity; i++) {

            if (table[i] != null && table[i].size() > 0) {

                for (Entry<K, V> entry : table[i]) {

                    builder.append(entry.toString() + ", ");

                }
            }
        }
        
        String res=builder.toString();
        
        if(res.length()>2)
         res =  builder.substring(0,builder.length()-2);

        res+=']';
        return res;
    }// end method

}// end class

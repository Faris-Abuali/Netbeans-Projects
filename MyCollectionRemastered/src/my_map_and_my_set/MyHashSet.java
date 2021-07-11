package my_map_and_my_set;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */

/*
clear() O(capacity) 
contains(e: E) O(1) 
add(e: E) O(1) 
remove(e: E) O(1) 
isEmpty() O(1) size() O(1) 
iterator() O(capacity) 
rehash() O(capacity)

*/
public class MyHashSet<E> implements MySet<E> {

    // Define the default hash-table size. Must be a power of 2 
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum hash-table size. Must be a power of 2
    private static int MAXIMUM_CAPACITY = 1 << 30;  // the same as 1 * Math.power(2,30)

    private int capacity;

    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    // Specify a load-factor threshold used in the hash table
    private float loadFactorThreshold;

    // The number of elements in the set 
    private int size = 0;

    // Hash table is an array with each cell being a linked list
    private LinkedList<E>[] table;

    public MyHashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int initialCapacity) {

        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public MyHashSet(int initialCapacity, float loadFactorThreshold) {

        if (initialCapacity > MAXIMUM_CAPACITY) {
            this.capacity = MAXIMUM_CAPACITY;
        } else {
            this.capacity = trimToPowerOf2(initialCapacity);
        }

        this.loadFactorThreshold = loadFactorThreshold;

        table = new LinkedList[capacity];
    }

    @Override
    public void clear() {

        size = 0;
        removeElements();
    }

    @Override
    public boolean contains(E element) {

        int bucketIndex = hash(element.hashCode());

        if (table[bucketIndex] != null) {

            for (E currElement : table[bucketIndex]) {
                if (currElement.equals(element)) {
                    return true;
                }
            }

        }

        return false;

    }// end method

    @Override
    public boolean add(E element) {

        if (contains(element)) {// Duplicate element not stored
            return false;
        }

        //===========================================================================================
        //If the program reches here, then the element does not exist in the table.
        // check load factor
        if (size + 1 >= capacity * loadFactorThreshold) {

            if (capacity == MAXIMUM_CAPACITY) {
                throw new RuntimeException("Exceeding maximum capacity");
            }

            rehash();
        }

        int bucketIndex = hash(element.hashCode());

        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<E>();
        }

        table[bucketIndex].add(element);
        size++;

        return true;

    }// end method

    @Override
    public boolean remove(E element) {

        if (!contains(element)) {
            return false;
        }

        int bucketIndex = hash(element.hashCode());

        if (table[bucketIndex] != null) {

            Iterator<E> bucket = table[bucketIndex].listIterator();

            while (bucket.hasNext()) {

                if (bucket.next().equals(element)) {
                    bucket.remove();
                    break;
                }
            }

        }

        size--;

        return true;

    }//end method

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
    
     public int capacity() {
        return capacity;
    }


    @Override
    public Iterator<E> iterator() { //create a forward iterator.
        return new MyHashSetIterator(this);
    }

    //==================================================================================================================
   
    private class MyHashSetIterator implements Iterator<E> {

        private ArrayList<E> list;
        private int current = 0;
        private MyHashSet<E> set;

        /**
         * Create a list from the set
         */
        public MyHashSetIterator(MyHashSet set) {

            this.set = set;
            list = setToList();
        }

        @Override
        /**
         * Next element for traversing?
         */
        public boolean hasNext() {

            if (current < list.size()) {
                return true;
            }

            return false;
        }// end mehtod

        @Override
        /**
         * Get current element and move cursor to the next
         */
        public E next() {
            return list.get(current++);
        }

        /**
         * Remove the current element and refresh the list
         */
        @Override
        public void remove() {

            set.remove(list.get(current)); // Delete the current element from the hash set 
            list.remove(current);// Remove current element from the lis

        }// end method

    }// end inner class MyHashSetIterator

    //==================================================================================================================
    public ArrayList<E> setToList() {

        ArrayList<E> list = new ArrayList<>();

        for (int i = 0; i < capacity; i++) {

            if (table[i] != null) {

                for (E currElement : table[i]) {
                    list.add(currElement);
                }
            }
        }// end for

        return list;

    }// end method

    /**
     * Remove all elements from each bucket
     */
    private void removeElements() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }

    }// end method

    public static int trimToPowerOf2(int initialCapacity) {

        int capacity = 1;

        while (capacity < initialCapacity) {
            capacity = capacity << 1; // Same as capacity = capacity * 2.  but << is more efficient
        }

        return capacity;
    }// end method

    private void rehash() {
        // Get entries
        ArrayList<E> list = setToList();  // copy to a list

        capacity = capacity << 1;  // same as capacity*=2 but more efficient

        table = new LinkedList[capacity];  // Create a new hash table
        size = 0;

        for (E currElement : list) {
            add(currElement); // Store to new table 
        }

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

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");

        ArrayList<E> list = setToList();

        for (int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i) + ", ");
        }

        if (list.size() == 0) {
            builder.append("]");
        } else {
            builder.append(list.get(list.size() - 1) + "]");
        }

        return builder.toString();
    }// end method

}// end class

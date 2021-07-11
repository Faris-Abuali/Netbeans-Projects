package my_map_and_my_set;

import com.sun.jdi.Value;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public interface MyMap<K, V> {

    public void clear(); //Removes all entries from this map. 

    public boolean containsKey(K key);  //Returns true if this map contains an entry for the     specified key. 

    public boolean containsValue(V value); // Returns true if this map maps one or more keys to the     specified value.

    public Set<Entry<K, V>> entrySet(); //Returns a set consisting of the entries in this map. 

    public V get(K key); //Returns a value for the specified key in this map.

    public boolean isEmpty(); //Returns true if this map contains no mappings.

    public Set<K> keySet(); //Returns a set consisting of the keys in this map.

    public V put(K key, V value);  //Puts a mapping in this map.

    public void remove(K key); //Removes the entries for the specified key.

    public int size();  //Returns the number of mappings in this map.

    public Set<V> values();  //Returns a set consisting of the values in this map.

           
    public static class Entry<K, V> {

        K key;
        V value;

        public Entry(K key, V value) { //Constructs an entry with the specified key and value.

            this.key = key;
            this.value = value;

        }

        //Returns the key in the entry

        public V getValue() {

            return value;
        }

         //Returns the value in the entry
        public K getKey(){
            return key;
        }
        
        
        @Override
        public String toString(){
            return "["+key+", "+value+"]";
        }
        

    }// end of Map.Entry

}// end interface

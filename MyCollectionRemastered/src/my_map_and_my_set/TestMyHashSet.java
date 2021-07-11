package my_map_and_my_set;

/**
 *
 * @author Fares Abu Ali
 */
public class TestMyHashSet {

    public static void main(String[] args) {

        MyHashSet<String> set = new MyHashSet<>();

        set.add("Smith");
        set.add("Anderson");
        set.add("Lewis");
        set.add("Cook");
        set.add("Smith");

        System.out.println(set.size());

        System.out.println(set.capacity());

        System.out.println(set.toString());

        System.out.println(set.setToList());

        System.out.println("Is Smith in set? " + set.contains("Smith"));

        set.remove("Smith");

        System.out.println(set);

        //========================================================================
        //Since the elements in a set are iterable, a foreach loop is used to traverse all elements in the set
        System.out.print("Names in set in uppercase are ");
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }
        //========================================================================
        
        

    }// end main

}// end class

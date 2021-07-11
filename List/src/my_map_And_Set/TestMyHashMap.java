package my_map_And_Set;

/**
 *
 * @author Fares Abu Ali
 */
public class TestMyHashMap {

    public static void main(String[] args) {

        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65);

        System.out.println(map.toString());

        System.out.println("The age for Lewis is: " + map.get("Lewis"));

        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));

        System.out.println("Is age 31 in the map? " + map.containsValue(31));
        
        map.remove("Smith");
        
        
        System.out.println(map);
        
        map.clear();
        
        System.out.println(map);

    }// end main
}// end class

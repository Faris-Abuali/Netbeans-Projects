
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class CountOccurenceOfWords {

    public static void main(String[] args) {

        String text = "Good morning. Have a good class."
                + " Have a good visit. Have fun!";
        
        System.out.println(text);

        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[ \n\t\r.,;:!?]");
        

        System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {

            String key = words[i].toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } 
                else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        System.out.println(map);

        Set<Map.Entry<String, Integer>> setOfEntries = map.entrySet();

        for (Map.Entry<String, Integer> currEntry : setOfEntries) {
            System.out.println(currEntry.getKey() + "\t" + currEntry.getValue());
        }
        
       

    }// end main
}// end class

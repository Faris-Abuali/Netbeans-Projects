package hashcodeconcept;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Fares Abu Ali
 */
public class HashCodeConcept {

    public static void main(String[] args) {

//        Integer obj1 = new Integer(2081);
//        System.out.println("Hashcode for integer 2081: " + obj1.hashCode());
//
//        String obj2 = "2081";
//        System.out.println("Hashcode for string 2081: " + obj2.hashCode());
//        
//        
//        String s1 = "AB";
//        System.out.println(s1.hashCode());
//        
//        
//         String s2 = "BA";
//        System.out.println(s2.hashCode());
//        HashSet<Integer> hs = new HashSet<>();
//
//        hs.add(2);
//        hs.add(1);
//        hs.add(33);
//        hs.add(0);
//        hs.add(-5);
//        hs.add(33);
//
//        System.out.println("HashSet: "+hs);
//
//        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
//
//        lhs.add(2);
//        lhs.add(1);
//        lhs.add(33);
//        lhs.add(0);
//        lhs.add(-5);
//        lhs.add(33);
//
//        System.out.println("LinkedHashSet: "+lhs);
//
//        TreeSet<Integer> ts = new TreeSet<>();
//
//        ts.add(2);
//        ts.add(1);
//        ts.add(33);
//        ts.add(0);
//        ts.add(-5);
//        ts.add(33);
//
//        System.out.println("TreeSet: "+ts);
//
//        Integer[] numbers = {19, 2, 586, 3, 7, 198, 657, 20, 0, -269};
//        
//        HashSet<Integer> hs = new HashSet<>();
//        
//        for(int i:numbers){
//            hs.add(i);
//        }
//        
//        System.out.println(hs);
//        HashMap<Integer, String> map = new HashMap();
//
//        System.out.println(map.put(50, "ali"));
//        map.put(60, "ahmad");
//        map.put(70, "Omar");
//        map.put(22, "Omar");
//
//      
//        

//        System.out.println(map.size());
//        map.put(60, "Haneen");
//
//        System.out.println(map.size());
//
//        System.out.println(map.put(50, "Wael"));

//        System.out.println(map);
//
//        Set<Integer> keys = map.keySet();
//
////        Iterator it = keys.iterator();
////
////        System.out.println("Iter");
////        while (it.hasNext()) {
////            System.out.print(it.next() + " ");
////        }
////        System.out.println(keys);
////
////        for (int i : keys) {
////            System.out.println(map.get(i));
////
////        }
////
////        Object[] keysArray = keys.toArray();
////
////        for (int i = 0; i < keysArray.length; i++) {
////            map.remove(keysArray[i]);
////        }
////        System.out.println("After remove: " + map);
////
////        map.put(null, "Fares");
////        map.put(null, "HAHA");
////
////        System.out.println(map.get(null));
////
////        System.out.println(map.entrySet());
////        
//        
//        
//          Iterator itr = map.entrySet().iterator();
//
//        while (itr.hasNext()) {
//            
//            Map.Entry current = (Map.Entry) itr.next();
//            
//            if(current.getKey().equals("matching")){
//                itr.remove();
//            }
//            
//            
//        }
//                System.out.println("Now: remove using iterator's remove(): "+map);


//----------------------------------HashMap--------------------------------------------      
        HashMap<Integer, List<String>> map = new HashMap<>();

        File f = new File("studentsAndMarks.txt");

        String name;
        int mark;

        try {
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {

                name = sc.next();
                mark = sc.nextInt();

                List<String> current = map.get(mark);

                if (current == null) {
                    current = new ArrayList<>();
                    map.put(mark, current);
                }

                current.add(name);
            }

            System.out.println(map.entrySet()); // as a set
            System.out.println(map); // as a map

//                    System.out.println(map.values());
//                    System.out.println(map.keySet());
//                    
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
        //----------------------------------HashMap--------------------------------------------  
    }


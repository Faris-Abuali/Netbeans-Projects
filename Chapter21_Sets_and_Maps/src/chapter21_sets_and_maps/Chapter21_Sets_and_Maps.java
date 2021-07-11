package chapter21_sets_and_maps;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class Chapter21_Sets_and_Maps {

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        list.add(1);
//        list.add(1);
//
//        Set<Integer> s = new HashSet<>(list);
//        
//        
//        
//         Iterator<Integer> itr = s.iterator();
//         
//         while(itr.hasNext()){
//             System.out.println(itr.next());
//         }
//
//
//        System.out.println("London".hashCode());
//        System.out.println("Paris".hashCode());
//        System.out.println("New York".hashCode());
//        System.out.println("San Francisco".hashCode());
//        System.out.println("Beijing".hashCode());
        //SortedSet<String> s = new TreeSet<>(new ArabicAlphabet());
        
        
        SortedSet<String> s = new TreeSet<>();

        s.add("Fares");
        s.add("Haneen");
        s.add("Faresa");
        s.add("Faresai");
        s.add("Faresi");
        s.add("Yosef");
        s.add("Ahmed");
        s.add("Ahmad");
        s.add("Ahmad Babar");
        s.add("Ahmad Anwar");
        
       


// SortedSet<Integer> s = new TreeSet<>(Collections.reverseOrder());
                //       s.add(1);
                //        s.add(33);
                //        s.add(11);
                //        s.add(17);
                //        s.add(-4);
                //        s.add(8);
                //        s.add(3);
                //        s.add(122);
                //        s.add(22);
                //        s.add(-9);
                //        s.add(0);
                
      

        System.out.println(s);

    }// end main

}//end class

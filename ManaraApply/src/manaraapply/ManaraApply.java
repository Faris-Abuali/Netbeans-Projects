/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manaraapply;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Fares Abu Ali
 */
public class ManaraApply {

    public static void binaryPatternMatching(String pattern, String s) {

       
        HashMap<Integer, Integer> map = new HashMap();

        if (map.get(2) == null) {
            map.put(2, 1);
        } else {
            map.put(2, map.get(2) + 1);
        }
        
        
       for(Map.Entry<Integer, Integer> entry : map.entrySet()){
           
           System.out.println(entry.getKey() +", "+entry.getValue());
       }
        
//        System.out.println(map.get(2));
    }// end method

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arrays.sort(args, 0, 0);
        
        

    }// end main

}// end class

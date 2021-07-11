/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midexam;

import java.util.ArrayList;

/**
 *
 * @author Fares Abu Ali
 */
public class Question2 {

    public static void removeRange(ArrayList list, int fromIndex, int toIndex) {

        int currIndex = fromIndex;

        while (currIndex != toIndex) {

            list.remove(fromIndex);

            currIndex++;

        }

    }

    public static void main(String[] args) {

        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(11);
        ar.add(22);
        ar.add(33);
        ar.add(44);
        ar.add(55);
        ar.add(66);
        ar.add(77);
        ar.add(88);
        
        System.out.println(ar);
        
        
        removeRange(ar, 2, 6);
        
        System.out.println(ar);

    }

}

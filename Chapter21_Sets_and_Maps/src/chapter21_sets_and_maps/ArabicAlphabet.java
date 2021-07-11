/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter21_sets_and_maps;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Fares Abu Ali
 */
public class ArabicAlphabet implements Comparator<String>, Serializable {

    @Override
    public int compare(String str1, String str2) {

        int i = 0;
        int char1 = 0;
        int char2 = 0;
        
        while (i < str1.length() && i < str2.length()) {

            char1 = str1.charAt(i);
            char2 = str2.charAt(i);
            
            
            
            if(char1<char2){
                return -1;
            }
            else if(char1>char2){
                return 1;
            }

            i++;
        }
        // if the program reaches here, this means that at least one of the two strings has finished and everytime 
        // it compares with the corresponding charachter in the other string, it is a tie (difference = 0)
        
        if(i>= str1.length() && i < str2.length()){
            return -1;
        }
        else if(i>= str2.length() && i < str1.length()){
            return 1;
        }
        else{
            return 0;
        }


    }//end method
    
    
//    public static void main(String[] args) {
//        
//        ArabicAlphabet a = new ArabicAlphabet();
//        
//        System.out.println(a.compare("Faresi","Faresar"));
//    }
    

}

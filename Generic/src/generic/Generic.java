/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Generic {

    public static void main(String[] args) {


//        Integer[] a={2,1,-3,-55};
//        
//        String[] stRay={"Tom","Susan","Kim"};
//        
//        sort(a);
//        
//    

ArrayList<Integer> list1=new ArrayList<>();
ArrayList<String> list2=new ArrayList<>();

    }
    
    
 
    
    public static <E extends Comparable<E> > E max(E o1, E o2){
        
        if(o1.compareTo(o2) > 0)
            return o1;
        return o2;
                   
    }
    public static <E extends Comparable <E> > void sort(E[] list){
        
        
        int minIndex;
        E minValue;
        
        for(int i=0;i<list.length-1;i++){
            
            minIndex=i;
            minValue=list[i];
            
            for(int j=i+1;j<list.length;j++){
                
                if(minValue.compareTo(list[j])>0){
                    
                    minValue=list[j];
                    minIndex=j;
                }
                
            }
            
            if(minIndex!=i){
            list[minIndex]=list[i];
            list[i]=minValue;
            }
            
        }
        
    }
    
    
    public static<E> void printList(E[] list){
        
        System.out.println("[ ");
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]+", ");
        }
        
        System.out.println("]");
        
    }
    
    
    
    
    
    
    
    
    
    

//    public <T> void printy(T[][] arr) {
//
//        for (T[] i : arr) {
//            for (T j : i) {
//                System.out.print(j + " ");
//            }
//        }
//        System.out.println("");
//
//    }
//
//    public static <E> void print(E[] arr) {
//        for (E e : arr) {
//            System.out.print(e + " ");
//        }
//        System.out.println("");
//    }
//
//    public static <E> void print(E[][] arr) {
//
//        for (E[] e : arr) {
//            for (E i : e) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//    }

}

package sort;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class InsertionSort {
    
    
    public static void insertion_sort(int[] A){
        
        for(int j=0;j<A.length;j++){
            
            int key = A[j]; 
            int i = j-1; // reversing index
            
            while(i>=0 && A[i]>key){
                
                A[i+1] = A[i];
                i--;
            }
            
            A[i+1]=key;
        }
        
    }// end method
    
    public static void osama(int[] a){
        
        for(int i=1;i<a.length;i++){
            
            int key=i;
            int j=key-1;
            
            while(a[key]<a[j] && j>=0){
                
                int p=a[j];
                a[j]=a[key];
                a[key]=p;
                key--;
                
                if(j>0){
                    j--;
                }
            }
        }
    }



    public static void sortAscending(int[] a) {

        System.out.println("Original Array:\n" + Arrays.toString(a) + "\n-------------------------------------");

        for (int i = 1; i < a.length; i++) {

            int currentElement = a[i];
            int rp = i - 1;  // reversing pointer

            while (rp >= 0 && a[rp] > currentElement) {
                a[rp + 1] = a[rp];
                //System.out.println(Arrays.toString(a));
                rp--;
            }

            a[rp + 1] = currentElement;
            //System.out.println(Arrays.toString(a));

        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{41, 62, 13, 84, 35, 96, 57, 28, 79};
        //sortAscending(a);
        
        //insertion_sort(a);
        
        osama(a);

        System.out.println(Arrays.toString(a));
    }

}

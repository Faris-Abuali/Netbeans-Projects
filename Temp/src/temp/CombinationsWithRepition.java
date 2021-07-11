
package temp;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */

/*
How to handle duplicates?
Note that the above method doesn’t handle duplicates. For example, if input array is {1, 2, 1} and r is 2, then the program prints {1, 2} and {2, 1} as two different combinations. We can avoid duplicates by adding following two additional things to above code.
1) Add code to sort the array before calling combinationUtil() in printCombination()
2) Add following lines at the end of for loop in combinationUtil()
*/

public class CombinationsWithRepition<E> {
    
    
    
        
    public void combinations(E[] arr,Object[] data,int timesTaken, int index, int startFrom){
        
        // arr[]: the entire original array (input array)
        // data[]: the array that should store the result
        // timesTaken: in terms of mathematical expression [nCr], timesTaken = r
 
        
        
        if( index == timesTaken){// then we should stop appending more elements to the (data[])
            System.out.println(Arrays.toString(data));
            return;
        }
        
        
        for(int j= startFrom;j<=arr.length;j++){
            
            if(arr.length-j-1 >= timesTaken-index-1){
                
                // (arr.length-j-1) ==> gives me the number of elements in front of arr[j]
                // (timesTaken-index-1) ==> gives me the minimum number of elements which should be in front of arr[j] to accept arr[j]
                
                // So, the number of elements in front of arr[j] SHOULD BE GREATER THAN OR EQUAL TO: (timesTaken-index-1) 
                
                data[index] = arr[j];
                combinations(arr, data, timesTaken, index+1, j+1);
                
                while(j+1<arr.length && arr[j]==arr[j+1]){
                    j++;
                }
            }
        }//end for
            
            
            
            //combinations(arr,data,taken,j+1)
        
    }//end method
    
    
    public void printAllCombinations(E[] arr,int timesTaken){
        
        // nCr : the combinations of (n) elements taken (r) each time = [ n!/ ( r! * (n-r)! ) ]
        
        
        Object[] data = new Object[timesTaken]; // this is to store the results (initially empty)
        Arrays.sort(arr);
        combinations(arr, data, timesTaken, 0,0);
        
    }// end method
    
    
    public static void main(String[] args) {
        
        //String[] arr = {"A","B","C","D","E"};
        
        CombinationsWithRepition c = new CombinationsWithRepition();
        
        
        String[] arr = new String[]{"C","C","C","A","T"};

        c.printAllCombinations(arr, 3);
        
        
        
    }// end main
    
    
}// end class

package temp;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class CombinationsWithoutRepition<E> {

    
    public static void getBinary(String str,int n){
        
        if(str.length()==n){
            System.out.println(str);
            return;
        }
        
        getBinary(str+"0",n);
        getBinary(str+"1",n);
        
        
    }// end method
    
    
    
    
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
            }
        }//end for
            
            
            
            //combinations(arr,data,taken,j+1)
        
    }//end method
    
    
    public void printAllCombinations(E[] arr,int timesTaken){
        
        // nCr : the combinations of (n) elements taken (r) each time = [ n!/ ( r! * (n-r)! ) ]
        
        
        Object[] data = new Object[timesTaken]; // this is to store the results (initially empty)
        
        combinations(arr, data, timesTaken, 0,0);
        
    }// end method
    
    
    public static void main(String[] args) {
        
        
        //getBinary("", 3);
        
        CombinationsWithoutRepition<Integer> c = new CombinationsWithoutRepition();
        
        Integer[] arr={1,2,3,4,5};
        

        c.printAllCombinations(arr,3);
        
        
     /*
        CombinationsWithoutRepition<String> c = new CombinationsWithoutRepition();
        
        String[] arr={"C","C","C","A","T"};
        

        c.printAllCombinations(arr,3);
    */
        
        
//        This code will not handle the case of repition :(
//                 int[] arr = {1,1,3,4,1};
//           printAllCombinations(arr,3);


//        int x = -5;
//        System.out.println("X before: " + Integer.toBinaryString(x)+ "   X = " + x);
//
//        x = x >> 1;
//        System.out.println("X after >>: " + Integer.toBinaryString(x) + "   X = " + x);
//
//        int y = -5;
//        System.out.println("\n\ny before: " + Integer.toBinaryString(y) + "   y = " + y);
//
//        y = y >>> 1;
//        System.out.println("y after >>>: " + Integer.toBinaryString(y) + "   y = " + y);
//        
//        
//        
//        
//         y = -5;
//        System.out.println("\n\ny before: " + Integer.toBinaryString(y) + "   y = " + y);
//
//        y = y << 1;
//        System.out.println("y after <<: " + Integer.toBinaryString(y) + "   y = " + y);
//        
       
        
    }// end main

}// end class

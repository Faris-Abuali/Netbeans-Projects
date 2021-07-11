package recursionjune2019;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class RecursionJune2019 {

    public static void main(String[] args) {

        
        int[]a={3,5,2,7,99,0};
        
        
        selectionSort(a);
        
        System.out.println(Arrays.toString(a));
        
        System.out.println(binarySearch(a,33));
        
        
        //--EndOfmain
    }

    public static void selectionSort(int[] a) {
        recursiveSelectionSort(a, 0);
    }

    public static void recursiveSelectionSort(int[] a, int i) {

        if (i == a.length) {
            return;
        }

        int minIndex = giveMinIndex(a, i + 1, i);

        if (minIndex == i) {// we don't need to swap
            recursiveSelectionSort(a, i + 1);
        }

        swap(a, i, minIndex);
        recursiveSelectionSort(a, i + 1);

    }

    public static int giveMinIndex(int[] a, int j, int minIndex) {

        if (j == a.length) {
            return minIndex;
        }
        if (a[j] < a[minIndex]) {
            return giveMinIndex(a, j + 1, j);
        }

        return giveMinIndex(a, j + 1, minIndex);

    }

    public static void swap(int[] a, int x, int y) {
//        a[x] = a[x] + a[y];
//        a[y] = a[x] - a[y];
//        a[x] = a[x] - a[y];

        int temp=a[x];
        a[x]=a[y];
        a[y]=temp;

    }
    
    
    public static int binarySearch(int[]a,int key){
        return helperBinarySearch(a, 0, a.length-1,key);
    }
    
    public static int helperBinarySearch(int[]a,int lowIndex,int highIndex,int key){
        
       int midIndex=(lowIndex+highIndex)/2;
        
        if(!isSorted(a))
            selectionSort(a);
        
        if(lowIndex>highIndex)
            return -1;
            
         if(key<a[midIndex])//highIndex=midIndex-1 
             return helperBinarySearch(a, lowIndex,midIndex-1, key);
         if(key>a[midIndex])//lowIndex=midIndex+1
             return helperBinarySearch(a, midIndex+1, highIndex, key);
         
         return midIndex;
            
    }

    

    private static boolean isSorted(int[] a) {
        
        for(int i=1;i<a.length;i++){
            if(a[i]<a[i-1])
                return false;
        }
        
        return true;
    }
    
    
    
    //--EndOfClass
}

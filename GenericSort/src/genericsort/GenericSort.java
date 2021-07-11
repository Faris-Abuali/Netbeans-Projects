package genericsort;

/**
 *
 * @author Fares Abu Ali
 */
public class GenericSort {
    
    public static <E extends Comparable<E>> void sort(E[] list) {
        
        for (int i = 0; i < list.length; i++) {
            
            E currentMin = list[i];
            int currentMinIndex = i;
            
            for (int j = i + 1; j < list.length; j++) {
                
                if (list[j].compareTo(currentMin) < 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }// end inner for
            
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
        
    }//end method sort
    
    public static void print(Object[] list) {
        
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        
        Integer[] intArr = new Integer[]{11, 8, 43, 7, 4};
        
        sort(intArr);
        
        print(intArr);
        
    }
    
}

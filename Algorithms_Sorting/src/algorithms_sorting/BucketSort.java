package algorithms_sorting;

import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class BucketSort {

    public static float[] toArray(ArrayList<Float> arList) {

        float[] outputArray = new float[arList.size()];

        for (int i = 0; i < arList.size(); i++) {
            outputArray[i] = arList.get(i);
        }

        return outputArray;
    }

    private static LinkedList<Float>[] makeArrayOfLinkedLists(int n) {

        LinkedList<Float>[] B = new LinkedList[n];
        for (int i = 0; i < B.length; i++) {
            B[i] = new LinkedList<>();
        }

        return B;

    }// end method

    private static void insertionSortForBucket(LinkedList<Float> bucket) {

        for (int j = 1; j < bucket.size(); j++) {

            int i = j - 1;
            float key = bucket.get(j);

            // float bucketOf_i = bucket.get(i);
            while (i >= 0 && bucket.get(i) > key) {
                bucket.set(i + 1, bucket.get(i));
                i--;
            }

            bucket.set(i + 1, key);
        }

    }// end method

    private static void printTheShapeOfTheBuckets(LinkedList<Float>[] B){
        
        System.out.println("--------- The Buckets -----------");
        for(int i=0;i<B.length;i++){
            
            System.out.print("| "+i+" |");
            
            for(int j=0;j<B[i].size();j++){
                
                System.out.print("-->");
                
                System.out.print("["+B[i].get(j)+"]");
            }
            
            System.out.println();
        }
    }
    public static float[] bucketSort(float[] A) {

        int n = A.length;

        LinkedList<Float>[] B = makeArrayOfLinkedLists(A.length); // Array of Buckets

        for (int i = 0; i < A.length; i++) {
            B[(int) (n * A[i])].add(A[i]);   //insert A[i] into list B[ floor(n*A[i]) ]
        }

        printTheShapeOfTheBuckets(B);
        
        
        //System.out.println("Now B:" + Arrays.toString(B));
        for (int i = 0; i < B.length; i++) {
            insertionSortForBucket(B[i]);
            // System.out.println(B[i]);
        }

        // System.out.println("Now B:" + Arrays.toString(B));
        //**********************************************************************************        
        // NOW: concatenate the lists B[0],B[1],..B[n-1] together in order
        float[] outputArray = new float[A.length];
        int index = 0;

        for (int j = 0; j < B.length; j++) {

            while (!B[j].isEmpty()) {
                outputArray[index] = B[j].removeFirst();
                index++;
            }
        }
        //**********************************************************************************
        return outputArray;
    }// end mertod

    public static float[] generateFloatArrayOfRangeZeroToOne(int n) {

        DecimalFormat df = new DecimalFormat("##.###");

        float[] ar = new float[n];

        for (int i = 0; i < n; i++) {
            float x = Float.parseFloat(df.format((float) (Math.random())));

            if(x==1){
                continue;
             }
             else{
            ar[i] = x;
            }
        }

        return ar;
    }

    public static void printLargeArray(float[] ar) {

        int ctr = 0;
        System.out.print("[");

        for (int i = 0; i < ar.length; i++) {

            System.out.print(ar[i] + ", ");
            ctr++;

            if (ctr == 20) {
                System.out.println();
                ctr = 0;
            }
        }

        System.out.println("]");

    }// end method

    public static void main(String[] args) {

//        DecimalFormat df = new DecimalFormat("#.###");
//
//        for (int i = 0; i < 33; i++) {
//            //System.out.println(Math.random());
//            System.out.println(df.format(Math.random()));
//        }
//        float[] A = new float[]{0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};
//
//        System.out.println("Input Array: " + Arrays.toString(A));
//
//        A = bucketSort(A);
//
//        System.out.println("Output Array: " + Arrays.toString(A));
        float[] ar = generateFloatArrayOfRangeZeroToOne(100);

        printLargeArray(ar);

        ar = bucketSort(ar);
        
        System.out.println("\n\nOutput Array: ");

        printLargeArray(ar);

    }// end main
}// end class

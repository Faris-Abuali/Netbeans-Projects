package recursionlab;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class RecursionLab {

    public static boolean isPalindrome(String str) {

        return isPalindrome(str, 0, str.length() - 1, false);

    }

    private static boolean isPalindrome(String str, int lowPtr, int highPtr, boolean flag) {

        if (lowPtr >= highPtr) {
            flag = true;
        } else if (str.charAt(lowPtr) == str.charAt(highPtr)) {
            flag = isPalindrome(str, lowPtr + 1, highPtr - 1, false);
        } else {
            flag = false;
        }

        return flag;

    }

    public static String reverse(String str) {

        if (!str.isEmpty()) {
            return reverse(str.substring(1)) + str.charAt(0);
        } else {
            return "";
        }
    }

    public static int power(int base, int exponent) {
        return power(base, exponent, 0);
    }

    private static int power(int base, int exponent, int res) {

        if (exponent == 0) {
            res = 1;
        } else {
            res = base * power(base, exponent - 1, 0);
        }

        return res;

    }

    public static <E> E[] reverseArray(E[] ar) {

        return reverseArray(ar, 0, ar.length - 1,ar.length/2);
    }

    private static <E> E[] reverseArray(E[] ar, int lowPtr, int highPtr,int count) {

        if (count==0) {
            return ar;
        }

        E temp = ar[lowPtr];
        ar[lowPtr] = ar[highPtr];
        ar[highPtr] = temp;

        return reverseArray(ar, lowPtr + 1, highPtr - 1,count-1);
    }
    
    
    public static int binarySearch(int[] ar,int key){
        return binarySearchRec(ar, key,0,ar.length-1);
    }
    
    
    private static int binarySearchRec(int[] ar,int key,int lowPtr,int highPtr){
        
        
        if(lowPtr>highPtr)
            return -1;
        
        int midPtr=(lowPtr+highPtr)/2;
       
        if(key<ar[midPtr])
            return binarySearchRec(ar, key, lowPtr,midPtr-1);
        else if(key>ar[midPtr])
            return binarySearchRec(ar, key, midPtr+1, highPtr);
        else
            return midPtr;
        
        
    }
    
    
    
    public static int gcd(int a,int b){
        
        if(a%b==0)
            return b;
        
        return gcd(b,a%b);
    }
    
    
    
   

    public static void main(String[] args) {
        //System.out.println(isPalindrome("ab"));

        //-----------------------Palindrome--------------------
//        System.out.println(isPalindrome("abccba"));            
//        System.out.println(isPalindrome("abcba"));
//        System.out.println(isPalindrome("abcdefgfedcba"));
//        System.out.println(isPalindrome("abcdba"));
        //-----------------------Palindrome--------------------
        //-----------------------Reverse--------------------
        //System.out.println(reverse("fa"));
        //-----------------------Reverse--------------------
        //-----------------------Power--------------------
       // System.out.println(power(2, 5));

        //-----------------------Power--------------------
        //-----------------------reverseArray--------------------
        Integer[] x = new Integer[]{11, 22, 33, 44, 55};
        
        System.out.println(Arrays.toString(reverseArray(x)));

        
        
        
        
        
        //--------binarySearch------------------
        //int[] ar=new int[]{11, 22, 33, 44, 55};
       
       // System.out.println(binarySearch(ar,12));
        //--------------------------------------
        
        
        System.out.println(gcd(25,50));
        
        
        
    }

}

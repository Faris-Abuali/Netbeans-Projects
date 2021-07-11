package firstdatastructureseptoct;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] a=new int[]{1,2,3,6};
        
        System.out.println(sumArray(a));
        
        System.out.println(reverseString("abcd"));
    }
    
    
    public static int sumArray(int[] a){
        return sumRec(a,0,0);
    }
    
    private static int sumRec(int[] a,int i,int commu){
        
        if(i==a.length-1){
            commu=a[i];
            return commu;
        }
        else{
            
            commu=a[i]+sumRec(a, i+1, commu);
            return commu;
        }
    }

    public static String reverseString(String str) {

        return funRec(str, "");
    }

    private static String funRec(String str, String res) {

        if (!str.isEmpty()) {

            res = funRec(str.substring(1), res) +                str.charAt(0);

        }

        return res;
    }
    //---------------------------------------------------

}

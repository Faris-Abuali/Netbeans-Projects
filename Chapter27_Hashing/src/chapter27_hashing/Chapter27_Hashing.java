package chapter27_hashing;

/**
 *
 * @author Fares Abu Ali
 */
public class Chapter27_Hashing {

    public static void main(String[] args) {

        System.out.println(Float.floatToIntBits(1f));

        String s = "Fares";

        System.out.println(modForNegative(-26, 3));

    }// end main

    private static int divide(int dividened, int divisor) {

        return divide(dividened, divisor, 0);
    }

    public static int divide(int dividened, int divisor, int ctr) {

        if (dividened < divisor) {
            return ctr;
        }

        return divide(dividened - divisor, divisor, ctr + 1);

    }

    private static int mod(int dividened, int divisor) {

        //System.out.println("dividend = " + dividened);
        // System.out.println("divisor = " + divisor);
        if (dividened < divisor) {
            return dividened;
        }
        
        

        return mod(dividened - divisor, divisor);

    }
    
     private static int modForNegative(int dividened, int divisor) {

        
        if (dividened > 0) {
            return dividened;
        }
        
        return modForNegative(dividened + divisor, divisor);

    }

}// ena class

package power;

/**
 *
 * @author Fares Abu Ali
 */
public class PowerEfficient {

    
    
    public static double power(double base, int exponent){
        
        if(exponent<0){
            exponent*=-1;
            base=1/base;
        }
        
        
        return powerRec(base, exponent);
    }
    public static double powerRec(double base, int exponent) {
        // O(Lg n) divivde and conquer

        if (exponent == 1) {
            return base;
        }

        double temp = powerRec(base, exponent / 2);

        if (exponent % 2 == 0) {
            return base * temp;
        } else {
            return base * temp * temp;
        }

    }// end method
    
    
    
    public static void main(String[] args) {
        System.out.println(power(2, -5));
    }

}// end class

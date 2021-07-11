package power;

/**
 * @author Fares Abu Ali
 */


public class Power {

    public static double power(double base, double exponent) {

       
        
        if(exponent<0){
            base=1.0/base;
            exponent=-exponent;
            
            System.out.println("expo :"+exponent);
            System.out.println("base :"+base);
            
        }
        
        return powerRec(base, exponent);
    }// end method

    public static double powerRec(double base, double exponent) {

        
        if(exponent==0){
            return 1;
        }
        
        return base*powerRec(base, exponent-1);
    }

    public static void main(String[] args) {

        
        
        System.out.println(Math.pow(3, 2));
        
        
       System.out.println(power((2.0/3), -4));
        
        
    }// end main
    
    //================================================================
    
    
    
    


}// end class

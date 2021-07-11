
package secondexam;

/**
 *
 * @author Fares Abu Ali
 */
public class Base {
    
    protected int multiplier(int data){
        
        return data*5;
    }
    
    
    
}

class Derivedd extends Base{
    
    private static int data;
    
    public Derivedd(){
        data=25;
    }
    public static void main(String[] args) {
        Base temp=new Derivedd();
        
        System.out.println(temp.multiplier(data));
               
    }
}

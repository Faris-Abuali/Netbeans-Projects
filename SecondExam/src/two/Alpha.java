/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two;

/**
 *
 * @author Fares Abu Ali
 */
public class Alpha {
    protected String type="A";
    public Alpha(){
        System.out.println("alpha");
    }
}

class Beta extends Alpha{
    String type;
    public Beta(){
        super();
        System.out.println("beta");
    }
    
    void go(){
        type="b";
        
        System.out.println(this.type+super.type);
    }
    
    public static void main(String[] args) {
        new Beta().go();
    }
}



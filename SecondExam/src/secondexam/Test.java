/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondexam;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {
     int data=5;
    
    public int getData(){
       
        return(data);
    }
 
 
}
class Derived extends Test{
     int data=99;
    
      public int getData(){
        return(data);
    }
}



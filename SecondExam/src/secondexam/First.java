/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secondexam;

/**
 *
 * @author Fares Abu Ali
 */
public class First {

    int i = 10;
public First(){
    
}
    public First(int j) {
        System.out.println(i);
        this.i = j * 10;
        
    }

}

class Second extends First {

    public Second(){
    }
    
    public Second(int j) {
        super(j);
        System.out.println(i);
        i = j * 20;
    }

}

class Maini{
    
    public static void main(String[] args) {
        Second n=new Second(20);
        
     
        System.out.println(n.i);
              
       
    }
}

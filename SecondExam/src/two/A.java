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
public class A {
   protected char c='A';
   char getValue(){
       return c;
   }
}

class B extends A{
    protected char c='B';
    char getValue(){
        return c;
    }
    
    char getSuperValue(){
        return super.c;
    }
}

class Mama{
    public static void main(String[] args) {
        
        A a=new B();
        B b=new B();
        
        System.out.println(a.c+" "+a.getValue()+" "+b.getValue()+b.getSuperValue()); //AB BA
        
    }
}

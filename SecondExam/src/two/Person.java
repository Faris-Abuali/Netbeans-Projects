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
public class Person {
    private void who(){
        
        System.out.println("Inside private method Person(who");
        
    }
    
    public static void whoAmI(){
        System.out.println("Inside static method, Person(whoAmI");
        
    }
    
    public void whoAreYou(){
        who();
        
        System.out.println("Imside virtual method,Person(whoAreYou)");
    }
}

class Kid extends Person{
    
    private void who(){
        System.out.println("Kid(who)");

    }
     public static void whoAmI(){
        System.out.println("Kid(whoAmI)");
        
    }
       public void whoAreYou(){
        who();
        
        System.out.println("Kid(whoAreYou)");
    }
    
    
}
class Fares{
    
    public static void main(String[] args) {
        Person p=new Kid();
        
        p.whoAmI();
        p.whoAreYou();
        
    }
}

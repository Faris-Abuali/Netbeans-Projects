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
class Derived  
{ 
    public void getDetails() 
    { 
        System.out.printf("Derived class "); 
    } 
} 

class Tests extends Derived 
{ 
    public void getDetails() 
    { 
        System.out.printf("Test class "); 
        super.getDetails(); 
    } 
    public static void main(String[] args) 
    { 
        Derived obj = new Tests(); 
        obj.getDetails(); 
    } 
}
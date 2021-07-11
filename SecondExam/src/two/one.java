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
class one 
{ 
	public void print_geek() 
	{ 
		System.out.println("Geeks"); 
	} 
} 

class two extends one 
{ 
	public void print_for() 
	{ 
		System.out.println("for"); 
	} 
} 

class three extends two 
{ 
	public void print_geek() 
	{ 
		System.out.println("Geeks"); 
	} 
} 

class Maind 
{ 
	public static void main(String[] args) 
	{ 
		three g = new three(); 
		g.print_geek(); 
		g.print_for(); 
		g.print_geek(); 
	} 
}
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
abstract class Vibrate 
{ 
	static String s = "-"; 
	Vibrate() 
	{ 
		s += "v"; 
	} 
} 
class Echo extends Vibrate 
{ 
	Echo() 
	{ 
		this(7); 
		s += "e"; 
	} 
	Echo(int x) 
	{ 
		s += "e2"; 
	} 
	public static void main(String[] args) 
	{ 
		System.out.print("made " + s + " "); 
	} 
	static
	{ 
		Echo e = new Echo(); 
		System.out.print("block " + s + " "); 
	} 
}
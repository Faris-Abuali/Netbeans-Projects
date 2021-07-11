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
class Building 
{ 
	Building() 
	{ 
		System.out.println("Geek-Buiding"); 
	} 
	Building(String name) 
	{ 
		this(); 
		System.out.println("Geek-building: String Constructor" + name); 
	} 
} 
class House extends Building 
{ 
    private int f=4;
	House() 
	{ 
		System.out.println("Geek-House "); 
	} 
	House(String name) //Geek
	{ 
		this(); 
                
		System.out.println("Geek-house: String Constructor" + name); 
	} 
	public static void main(String[] args) 
	{ 
            
		new House("Geek"); 
	} 
}
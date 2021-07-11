package recursionjune2019;

import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class TowerOfHanoi {

    /*
    1. Move the first (n-1) disks from A to C with the assistance of tower B
    2. Move the disk n from A to B
    3. Move the (n-1) disks from C to B with the assistance of tower A
    */
    
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter number of disks:");
        int n=sc.nextInt();
        
        System.out.println("The moves are:\n");
        moveDisks(n,'A','B','C');
        
        
    }
            
    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {

        if(n==1)
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
        else{
            moveDisks(n-1,fromTower,auxTower,toTower);
            System.out.println("move disk "+n+" from "+fromTower+" to "+toTower);
            moveDisks(n-1, auxTower, toTower, fromTower);   
        }
    }

//EndOfClass
}

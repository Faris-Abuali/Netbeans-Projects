
package fullfinalproject2ndsemester2019safarini;

import java.lang.reflect.Array;
import java.util.*;

import javax.swing.JOptionPane;

public class RockPaperScissors {
    
public static void main(String[] args) {

    System.out.println("Welcome to my Rock,Paper,Scissors program:\n--------------------------------------");
Scanner sc = new Scanner(System.in);
// System.out.println("Name = Fares Hatem Abu Ali ");
// -----------------------------------------------------------//

String mode=JOptionPane.showInputDialog(null, "press 1 if you want \"1player mode\" , or press 2 if you want \" 2players mode\" ");
String s1,s2;
String name1,name2;
if(mode.equals("2")) 
{
//JOptionPane.showMessageDialog(null, "Player #1's choice : ");
name1=JOptionPane.showInputDialog(null,"Enter the 1st player's name "); 
name2=JOptionPane.showInputDialog(null,"Enter the 2nd player's name ");
s1=JOptionPane.showInputDialog(null,"Choose \'r' for Rock , \'p' for paper or 's' for scissors\n "+ name1+"'s choice :"); 
//JOptionPane.showMessageDialog(null, "Player #2's choice : ");
s2=JOptionPane.showInputDialog(null,"Choose \'r' for Rock , \'p' for paper or 's' for scissors\n "+ name2+"'s choice :"); 
}
else {
name1=JOptionPane.showInputDialog(null,"Enter your name "); 
name2="The Computer ";
s1=JOptionPane.showInputDialog("Choose \'r' for Rock , \'p' for paper or 's' for scissors\n"); 
String[] ar = {"r","p","s"};
int index=(int) (Math.random()*3); // from 0 to 2
s2=ar[index];

JOptionPane.showMessageDialog(null, "The Computer chose : "+s2);
}

JOptionPane.showMessageDialog(null, result(s1,s2,name1,name2));


//String s=JOptionPane.showInputDialog(null,"Enter the animal's age :" ); 
//int n=Integer.parseInt(s);

//System.out.println(humanAge(n));

//int term = Integer.parseInt(s);
//JOptionPane.showMessageDialog(null, "number of digits = "+numOfDigits(n));
// JOptionPane.showMessageDialog(null, "The sum to the term "+term+" = "+seriesSum(term));


/*
if(isArmstrong(n))
JOptionPane.showMessageDialog(null, "The number is Armstrong");
else
JOptionPane.showMessageDialog(null, "Not Armstrong");
*/


//---STOP--- 
}
public static String result(String s1,String s2,String name1,String name2) {
//---1---ROCK
if(s1.equals("r")) 
{
if(!s2.equals("p"))
{
if(!s2.equals("r")) 
return (name1+" wins."+" Hardluck for "+ name2);
else
return "it is a tie ";
}
else return (name2+" wins."+" Hardluck for "+ name1);
}
//---2---PAPER
if(s1.equals("p")) 
{
if(!s2.equals("s"))
{
if(!s2.equals("p"))
return (name1+" wins."+" Hardluck for "+ name2);
else
return "it is a tie ";
}
else return (name2+" wins."+" Hardluck for "+ name1);
}
//---3--- Now if the compiler arrived here , s1 would be SCISSORS

if(!s2.equals("r")) {
if(!s2.equals("s"))
return (name1+" wins."+" Hardluck for "+ name2);
return "it is a tie ";
}
return (name2+" wins."+" Hardluck for "+ name1);

}

public static int sumOfDigits(int n){
int sum=0;
while(n!=0){
sum+=n%10;
n/=10;
}

return sum;
}

public static int numOfDigits(int n){
int ctr=0;
while(n!=0){
ctr++;
n/=10;
}

return ctr;
}

public static double seriesSum(int term){

double sum=0;
for(int i=1;i<=term;i++)
sum+= ((double) i/((i+2)*3) );

return sum;

}

public static boolean isArmstrong(int n)
{
int copy_of_n=n;
int sum=0;
int e=numOfDigits(n);

while(n!=0)
{
int digit=n%10;
sum+=Math.pow(digit, e);

n/=10;

}
if(sum==copy_of_n)
return true;
else
return false;


}

public static double humanAge(int animalAge)
{

if(animalAge<=20)
return animalAge/10.0;

return 1+humanAge(animalAge-5);

}
//---EndOfClass---
}
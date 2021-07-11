
package fullfinalproject2ndsemester2019safarini;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Calendar {
	//Methods-----
	 public static int day(int month, int day, int year) {
	        int y = year - (14 - month) / 12;
	        int x = y + y/4 - y/100 + y/400;
	        int m = month + 12 * ((14 - month) / 12) - 2;
	        int d = (day + x + (31*m)/12) % 7;
	        return d;
	    }
	 
	 public static boolean isLeap(int y) {

		 if(y%4==0 && y%100!=0 || y%400==0)
			 return true;
		 return false;
	 }
//Now the main method:	 
	 
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the year please: ");
	int year=sc.nextInt();
	
/**/String[] orderOfDays= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	String firstDay=orderOfDays[day(1, 1, year)];   // the function : day(month, day, year) will return a number from 0 to 6

	if(year>2019)
	System.out.println("The first day inshallah will be: "+firstDay+" :)\n");
	else
		System.out.println("The first day was: "+firstDay+" :)\n");

	if(isLeap(year))
		System.out.println("Note that "+year+" is a leap year, so February has "+29+" days  :)\n");


		for(int month=1;month<13;month++)
		{		int until;
		/**/int[] numOfDaysInTheMonth= {31,28,31,30,31,30,31,31,30,31,30,31};
		if(isLeap(year))
			numOfDaysInTheMonth[1]=29;
		until=numOfDaysInTheMonth[month-1];

		/**/String []monthName= {"January","February","March","April","May","June","July","August","Septemper","October",
														"November","December"};
		
		System.out.println(monthName[month-1] +"  "+ year);
		System.out.println("Su\tM\tTu\tW\tTh\tF\tSa");
		int spaces=day(month, 1,year);
		for(int s=0;s<spaces;s++)
			System.out.print('\t'+" ");
		
				for(int j=1;j<=until;j++) {
					if(j<10)
						System.out.print("0");
					System.out.print(j+"\t");
					if((j+spaces)%7==0)
						System.out.println();
					//System.out.println();
				}
				System.out.println("\n--------------------------------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Calendar.class.getName()).log(Level.SEVERE, null, ex);
            }
		}

	
	//---EndOfmain
}
//---EndOfClass
}



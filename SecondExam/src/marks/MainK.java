/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marks;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class MainK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int num = sc.nextInt();

      
        
        Student std[] = new Student[num];

       
        
        for (int i = 0; i < num; i++) {
            std[i]=new Student();
            System.out.println("Enter name of student: ");
            String namee = sc.next();
            std[i].setName(namee);
            System.out.println("Enter age of student: ");
            int age = sc.nextInt();
            std[i].setAge(age);
            
            System.out.println("Enter first,second,final grades respectively:");
            double f,s,fi;
            f=sc.nextDouble();
            s=sc.nextDouble();
            fi=sc.nextDouble();
            System.out.println(f+s+fi);
            std[i].mark=new Marks(f, s, fi,0);
//            std[i].mark.setFirst(i);
//            std[i].mark.setSecond(s);
//            std[i].mark.setFinali(fi);
            

            System.out.println(std[i].toString());
        }
        
        
        int maxIndex=0;
        for(int i=0;i<num;i++){
            double maxGrade=std[i].mark.getAvgGrade();
             maxIndex=i;
            for(int j=i+1;j<num;j++){
                if(std[j].mark.getAvgGrade()>std[i].mark.getAvgGrade()){
                    maxGrade=std[j].mark.getAvgGrade();
                    maxIndex=j;
                }
            }
            
            Student temp=std[i];
            std[i]=std[maxIndex];
            std[maxIndex]=temp;
        }
        
       
    }
}

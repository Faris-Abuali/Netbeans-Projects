/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revision;

/**
 *
 * @author Fares Abu Ali
 */
public class Revision // this is the ENTRY POINT
{

    
    public static void main(String[] args)
    {
        
      
        Department d1 = new Department(1,"Information Systems");
        
         SalariedEmployee se1 = new SalariedEmployee("Fares",1,"Khobar",Gender.male,15000,3000,0);
        d1.add_employee(se1);  // Now the object se1 is from the class SalariedEmployee specifically 
        
        HourlyEmployee he1 = new HourlyEmployee("Yosef",2,"Tulkarm",Gender.male,150,8);
        d1.add_employee(he1);
        
        CommissionEmployee ce1 = new CommissionEmployee("Haneen",3,"Riyadh",Gender.female,200,50);
        d1.add_employee(ce1);
        
        System.out.println("size = "+d1.getEmployeeCount());
        
        d1.print_basic_data();
        
        d1.print_all_details();
        
        
    }
    
}

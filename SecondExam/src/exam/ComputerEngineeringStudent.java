/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author Fares Abu Ali
 */
public class ComputerEngineeringStudent extends GeneralStudent {

    private String department, dean;

    public ComputerEngineeringStudent() {
    }

    public ComputerEngineeringStudent(int id, String name, String address, String phNo, double gPA,
            String deString, String dean) {
        super(id, name, address, phNo, gPA);
        this.department = department;
        this.dean = dean;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }


     
//    public void MakeCall(int num){
//           
//        if (num == 0) {
//            return;
//        }
//
//        MakeCall(num / 16);
//        if (num % 16 > 10) {
//            System.out.print((char) (num % 16 + 'A' - 10));
//        } else {
//            System.out.print(num % 16);
//        }
//
//    
//    }
    
  public void makeCall(){
      System.out.println(Integer.parseInt(this.getPhoneNumber(), 16));
  }

  
  
}

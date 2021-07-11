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
public class GeneralStudent {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private double gPA;

    public GeneralStudent(){
        
    }

    public GeneralStudent(int id, String name, String address, String phoneNumber, double gPA) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gPA = gPA;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhNo(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getgPA() {
        return gPA;
    }

    public void setgPA(double gPA) {
        this.gPA = gPA;
    }

    @Override
    public String toString() {
        return "GeneralStudent{" + "id=" + id + ", name=" + name + ", address=" + address + ", phoneNumber=" + phoneNumber + ", gPA=" + gPA + '}';
    }
    
    public void makeCal(){
        
    }
}

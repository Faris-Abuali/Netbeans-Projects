package employee;

/**
 *
 * @author Fares Abu Ali
 */
abstract class Employee {

    private String firstName;
    private String lastName;
    private int SSN;//Social Security Number

    public Employee(String firstName, String lastName, int SSN) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = SSN;
    }

//Setters and Getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSocialSecurityNumber() {
        return SSN;
    }

    public void setSocialSecurityNumber(int SSN) {
        this.SSN = SSN;
    }
// abstract method overridden by concrete subclasses 
    public abstract double earnings();

//    @Override
//    public String toString() {
//        return "*******a new Employee's info list:*******\n{" + "FirstName=" + firstName + ", LastName=" + lastName + ", Social Security Number=" + SSN + "}\n------------------------------------------------------------------\n";
//    }
    
    @Override
    public String toString(){
        return "*"+firstName+" "+lastName+"*\n"+"Social Security Number: "+SSN+"\n";
    }
    //--EndOfClass
}

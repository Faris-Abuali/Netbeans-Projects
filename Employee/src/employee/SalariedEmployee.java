package employee;

/**
 *
 * @author Fares Abu Ali
 */
public class SalariedEmployee extends Employee {
//firstName,LastName,SSN,weeklySalary

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, int SSN, double weeklySalary) {

        super(firstName, lastName, SSN);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary >= 0.0) {
            this.weeklySalary = weeklySalary;
        } else {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }

    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "{ Weekly Salary=" + weeklySalary + "}\n------------------------------------------------------------------\n";
//    }
    
      @Override
    public String toString() {
        return super.toString() + "Weekly Salary:" + weeklySalary +"$\n";
    }

    //--EndOfClass
}

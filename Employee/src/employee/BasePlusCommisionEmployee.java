package employee;

/**
 *
 * @author Fares Abu Ali
 */
public class BasePlusCommisionEmployee extends CommisionEmployee {
    //firstName,lastName,SSN,grossSales,commisionRate,baseSalary

    private double baseSalary;

    public BasePlusCommisionEmployee(String firstName, String lastName, int SSN,
            double grossSales, double commisonRate,
            double baseSalary) {
        super(firstName, lastName, SSN, grossSales, commisonRate);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        if (baseSalary >= 0) {
            return baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double earnings() {
        return baseSalary + super.earnings();
    }

//    @Override
//    public String toString() {
//        return super.toString() + "{Base Salary=" + baseSalary + "$}\n------------------------------------------------------------------\n";
//    }
    @Override
    public String toString() {
        return super.toString() + "Base Salary:" + baseSalary + "$\n";
    }

    //-EndOfClass
}

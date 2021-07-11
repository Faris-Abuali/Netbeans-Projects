package employee;

/**
 *
 * @author Fares Abu Ali
 */
public class CommisionEmployee extends Employee {

    //firstName,lastName,SSN,grossSales,commisionRate
    private double grossSales; //gross weekly sales (gross means:total)
    private double commisionRate; //commision percentage

    public CommisionEmployee(String firstName, String lastName, int SSN, double grossSales, double commisonRate) {
        super(firstName, lastName, SSN);
        this.grossSales = grossSales;
        this.commisionRate = commisonRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales >= 0.0 && grossSales <= 1.0) {
            this.grossSales = grossSales;
        } else {
            throw new IllegalArgumentException("commision rate must be between 0 and 1 only");
        }

    }

    public double getCommisionRate() {
        return commisionRate;
    }

    public void setCommisionRate(double commisionRate) {
        this.commisionRate = commisionRate;
    }

    @Override
    public double earnings() {
        return commisionRate * grossSales;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "{Gross Sales="+grossSales+"$, Commision Rate="+commisionRate+"%}\n------------------------------------------------------------------\n";
//    }
    @Override
    public String toString() {
        return super.toString() + "Gross Sales:"+grossSales+"$\nCommision Rate:"+commisionRate+"%\n";
    }


    //-EndOfClass
}

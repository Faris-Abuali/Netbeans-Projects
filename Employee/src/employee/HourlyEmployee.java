package employee;

/**
 *
 * @author Fares Abu Ali
 */
class HourlyEmployee extends Employee {

    //firstName,lastName,SSN,hourlyWage,workHours
    private double hourlyWage;
    private double workHours;

    public HourlyEmployee(String firstName, String lastName, int SSN,double hourlyWage, double workHours) {
        super(firstName, lastName, SSN);
        this.hourlyWage = hourlyWage;
        this.workHours = workHours;
    }

    public double getWage() {
        return hourlyWage;
    }

    public void setWage(double hourlyWage) {

        if (hourlyWage >= 0.0) {
            this.hourlyWage = hourlyWage;
        } else {
            throw new IllegalArgumentException("Hourly hourlyWage must be >= 0.0");
        }

    }

    public double getHours() {
        return workHours;
    }

    public void setHours(double workHours) {
        this.workHours = workHours;
    }

    @Override
    public double earnings() {
        
        if(workHours<=40)
            return workHours*hourlyWage;
        else
            return 40*hourlyWage+(workHours-40)*hourlyWage*1.5;
    }

//    @Override
//    public String toString() {
//        return super.toString() + "{ Wage=" + hourlyWage + ", Hours worked=" + workHours + "}\n------------------------------------------------------------------\n";
//    }
    
    @Override
    public String toString() {
        return super.toString() + "Hourly Wage:" + hourlyWage +"$\n"+"Hours worked:" + workHours + "\n";
    }

    //--EndOfClass
}

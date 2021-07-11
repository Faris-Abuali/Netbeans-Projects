
package employee;

/**
 *
 * @author Fares Abu Ali
 */
class Main {

    public static void main(String[] args) {
        System.out.println("$$$ Welcome to my EMPLOYEE PAYROLL SYSTEM $$$\nDeveloped by:Fares AbuAli"
                + "\n---------------------------------------------------");
        
        System.out.println("Now I well Test the whole system to ensure it works properly: ");
        
        
        SalariedEmployee se = new SalariedEmployee("Fares", "Abu Ali", 201810408, 3000);
        HourlyEmployee he = new HourlyEmployee("Mohammad", "Ahmad", 201720406, 100, 40);
        CommisionEmployee ce = new CommisionEmployee("Ali", "Omar", 201644456, 5000, 0.77);
        BasePlusCommisionEmployee bpce = new BasePlusCommisionEmployee("Bashar", "Waleed", 201810408, 8000, 0.7, 500);

        System.out.println("Employees processed individualy and everything worked successfully.");
        System.out.println(se);
        System.out.println(he);
        System.out.println(ce);
        System.out.println(bpce);
        System.out.println("");

        //--Now I will test the polymprphism
        System.out.println("Now I will test the polymprphism");
        Employee[] emp = new Employee[4];

        emp[0] = se;//object of SlariedEmployee Class
        emp[1] = he;//object of HourlyEmployee class
        emp[2] = ce;//object of CommisionEmployee class
        emp[3] = bpce;//object of BasePlusCommisionEmployee class

        System.out.println("Employees processed polymorphically:\n");

        for (Employee currentEmployee : emp) {

            System.out.print(currentEmployee); //invokes toString() 

            if (currentEmployee instanceof BasePlusCommisionEmployee) {

                //Downcast Employee reference to BasePlusCommisionEmployee reference
                //then invoke the method setBaseSalary to increase the baseSalary by %10
                BasePlusCommisionEmployee temp = (BasePlusCommisionEmployee) currentEmployee;

                temp.setBaseSalary(1.10 * temp.getBaseSalary()); // increase by %10

                System.out.println("update: We would like to inform you that your base salary\n"
                        + "has been increased by 10% and is now: " + temp.getBaseSalary() + "$");

            }

            System.out.println("earned: " + currentEmployee.earnings() + "$\n-----------------------------------------------------");

            //now get type name of each object in emp array
        }
        for (int i = 0; i < emp.length; i++) {
            System.out.println("employee " + i + " is an " + emp[i].getClass().getName());
        }
        //--EndOfmain
    }

    //--EndOfClass
}

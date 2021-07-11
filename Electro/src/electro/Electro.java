package electro;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Electro {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int RS, RD;

        System.out.println("Enter the value of RS & RD: ");

        System.out.print("RS = ");
        RS = sc.nextInt();

        System.out.print("RD = ");
        RD = sc.nextInt();

        System.out.println("\na) Determine the dc drain current ID. ");
        double IDplus, IDminus;

        double b = (-1 / 400.0) * RS - 1;
        double a = (1 / 1920.0) * RS * RS;
        double c = 3.0 / 1000;

        IDplus = -b + Math.sqrt(b * b - 4 * a * c);

        IDplus /= (2 * a);

        IDminus = -b - Math.sqrt(b * b - 4 * a * c);

        IDminus /= (2 * a);

        IDplus *= 1000;
        IDminus *= 1000;

        DecimalFormat df = new DecimalFormat("##.##");

        System.out.println();

        IDplus = new Double(df.format(IDplus));
        IDminus = new Double(df.format(IDminus));

        System.out.println(ANSI_RED+"ID1 = " + IDplus + " mA"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"ID2 = " + IDminus + " mA"+ANSI_RESET);

       
        System.out.println("=============================================");

        IDplus /= 1000;
        IDminus /= 1000;

        System.out.println("b) Determine the value of VGS.");
        double VGS = -IDminus * RS;

        VGS = new Double(df.format(VGS));

        System.out.println(ANSI_GREEN+"VGS = " + VGS + " Volt"+ANSI_RESET);

        System.out.println("=============================================");

        System.out.println("c) Determine the value of VDS");

        double VD = 10 - IDminus * RD;
        double VS = -VGS;
        double VDS = VD - VS;

        System.out.println(ANSI_GREEN+"VDS = " +df.format(VDS)+ " Volt"+ANSI_RESET);

    }// end main

}// end class

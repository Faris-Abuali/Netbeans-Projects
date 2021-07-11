package fibonacci;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Test {

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

        Fibonacci obj = new Fibonacci();

        System.out.println(obj.fiboMemoization(50));
        //System.out.println(Arrays.toString(obj.getArray()));

        System.out.println("3rd Way: Memoization");
        System.out.println(ANSI_PURPLE+"Time Elapsed:" + obj.getElapsedTime()+" msec"+ANSI_RESET);
        System.out.println("----------------------------\n");

        System.out.println(obj.fiboCuurentPrevious(50));

        System.out.println("2nd Way: Store Current,Previous parameters");
        System.out.println(ANSI_PURPLE+"Time Elapsed:" + obj.getElapsedTime()+" msec"+ANSI_RESET);
        System.out.println("----------------------------\n");

        System.out.println(obj.fibonacciRegular(50));

        System.out.println("1st Way: Regular fibonacci without storage");
        System.out.println(ANSI_PURPLE+"Time Elapsed:" + obj.getElapsedTime()+" msec"+ANSI_RESET);
        System.out.println("----------------------------\n");

    }
}

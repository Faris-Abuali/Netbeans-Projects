package deadlock_avoidance;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author Fares Abu Ali
 */
public class BankersAlgorithm {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    int n, m;  // n is the # of processes P & m is the number of resource types R

    int[] available = new int[m];  // vector of length m, indicates the # of available reosources of each
    // resource type.  available[j] = k means that there are k instances of resource type Rj available

    int[][] max = new int[n][m];
    /*defines the maximum demand of each thread. If Max[i][j] = k, then process Pi may request at most k
    instances of resource type Rj
     */

    int[][] allocation = new int[n][m];
    /* # of resources of each type currently allocated */

    int[][] need = new int[n][m];  // Need[i][j] = Max[i][j] - Allocation[i][j]

    /*the remaining resource need of each process*/
    //===============================================================================
    /* is a vector for process Pi. If request_i[j] = k, then process Pi wants k
    / instances of resource type Rl */
    public BankersAlgorithm(int n, int m, int[][] max, int[][] allocation, int[] available) {

        this.n = n;
        this.m = m;
        this.available = available;
        this.max = max;
        this.allocation = allocation;
        calculateNeedMatrix();

//        System.out.println(Arrays.toString(available));
//        System.out.println(Arrays.deepToString(max));
//        System.out.println(Arrays.deepToString(allocation));
    }// end constructor

    public void calculateNeedMatrix() {

        int[][] need = new int[n][m];
        for (int i = 0; i < n; i++) {
            need[i] = new int[m];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        this.need = need;

        //System.out.println(Arrays.deepToString(need));
    }// end method

    public void printMatrix() {

        System.out.println("Available:- ");

        System.out.println(Arrays.toString(available));
        System.out.println("");

        System.out.println("Max:-");

        for (int j = 0; j < this.n; j++) {

            System.out.println(Arrays.toString(this.max[j]));

        }
        System.out.println("");

        System.out.println("Allocation:-");

        for (int j = 0; j < this.n; j++) {

            System.out.println(Arrays.toString(this.allocation[j]));

        }

        System.out.println("");

        System.out.println("Need:-");
        for (int j = 0; j < this.n; j++) {

            System.out.println(Arrays.toString(this.need[j]));

        }

        System.out.println("=====================================");

    }// end method

    public boolean is_Need_greater_than_Work(int i, int[] work) {

        // compare the need(i) which is the need for process Pi, with the work
        boolean flag = false;

        for (int j = 0; j < m; j++) {
            if (need[i][j] > work[j]) {
                flag = true;
                break;
            }
        }

        return flag;

    }// end method

    public int[] increase_Work_by_alloc_i(int i, int[] work) {

        for (int j = 0; j < m; j++) {
            work[j] += allocation[i][j];
        }

        return work;
    }

    public boolean safetyAlgorithm() {

        LinkedList<String> safeSequence = new LinkedList<>();

        boolean isSafe = true;

        // Step 1: ========================================================
        int[] work = new int[m];

        for (int i = 0; i < m; i++) {
            work[i] = available[i];
        }

        //System.out.println("Work = "+ Arrays.toString(work));
        boolean[] finish = new boolean[n];

        //System.out.println("Finish = "+ Arrays.toString(finish));
        // Step 2: ========================================================
        for (int i = 0; i < n; i++) {

            // System.out.println("Finish["+i+"] = "+finish[i]+", need["+i+"] = "+Arrays.toString(need[i]));
            // System.out.println("Work = "+Arrays.toString(work));
            // System.out.println();
            if (finish[i] == false && is_Need_greater_than_Work(i, work) == false) {

                System.out.println("Step 2: For i = " + i + ": ");

                System.out.println("Finish[" + i + "] = " + finish[i] + " and ");
                System.out.println("need[" + i + "] <= " + " work   (" + Arrays.toString(need[i]) + " <= " + Arrays.toString(work) + ")");

                System.out.println(ANSI_GREEN + "So process P" + i + " must be kept in the safe sequence" + ANSI_RESET);
                safeSequence.add("P" + i);

                System.out.println("Step 3:");
                System.out.println("work = work + allocation[" + i + "]");
                System.out.println("work = " + Arrays.toString(work) + " + " + Arrays.toString(allocation[i]));

                //Step 3: work = work + allocation[i], Finish[i] = True
                increase_Work_by_alloc_i(i, work);
                finish[i] = true;

                System.out.println("work = " + Arrays.toString(work));
                System.out.println("Finish[" + i + "] = " + finish[i]);
                System.out.println("Finish = " + Arrays.toString(finish));
                System.out.println("====================================================");

                i = -1; // to force it to start again from beginning searching for a process Pi that satisfies the condition
            } else if (finish[i] == false) {

                System.out.println("Step 2: For i = " + i + ": ");

                System.out.print("Finish[" + i + "] is false and ");
                System.out.println("need[" + i + "] > " + "work   (" + Arrays.toString(need[i]) + " > " + Arrays.toString(work) + ")");

                System.out.println(ANSI_RED + "So process P" + i + " must wait" + ANSI_RESET);
                System.out.println("====================================================");

            }

        }// end step 2

        // Step 4: ========================================================
        for (int i = 0; i < finish.length; i++) {

            if (finish[i] == false) {
                isSafe = false;
                System.out.println("The process P" + i + " will be deadlocked!");
            }
        }

        System.out.println(ANSI_GREEN + "Safe Sequence: " + safeSequence.toString() + ANSI_RESET);
        return isSafe;
    }// end method safety algorithm

    public boolean deadlock_avoidance(int[] request_i, int i) { // the request and the process Pi that makes the request

        System.out.println("Origianl Available,Max,Allocation,Need:");
        printMatrix();

        // int i tells me which process Pi has made the request
        boolean flag = true;

        //1. process Pi makes request[i] vector
        System.out.println("1. Process P" + i + " makes reqest " + Arrays.toString(request_i));

        //2. if request_i > need[i] then there's an error
        System.out.println("2. ");
        for (int j = 0; j < m; j++) {
            if (request_i[j] > need[i][j]) {
                flag = false;
                System.out.println("request[" + i + "] > need[" + i + "]    (" + Arrays.toString(request_i) + " > " + Arrays.toString(need[i]) + ")");
                System.out.println("So there's an error, because the process cannot request more than its need");
            }
        }

        if (flag) {
            System.out.println("request[" + i + "] <= need[" + i + "]    (" + Arrays.toString(request_i) + " <= " + Arrays.toString(need[i]) + ")");
        }

        //3. if request_i > available, then process Pi must wait; because it is requesting instances more than the available
        // right now
        System.out.println("3. ");
        for (int j = 0; j < m; j++) {
            if (request_i[j] > available[j]) {
                flag = false;
                System.out.println("request[" + i + "] > available[" + i + "]    (" + Arrays.toString(request_i) + " > " + Arrays.toString(allocation[i]) + ")");
                System.out.println("then process P" + i + " must wait; because it is requesting instances more than "
                        + "the available right now");
            }
        }

        if (flag) {
            System.out.println("request[" + i + "] <= available[" + i + "]    (" + Arrays.toString(request_i) + " <= " + Arrays.toString(allocation[i]) + ")");
        }

        if (flag) {

            /* 4. Pretend to allocate requested resources to Pi by modifying the state as follows:        
                available = available - request_i
                allocation[i] = allocation[i] + request_i
                need[i] = need[i] - request_i   
             */
            System.out.println("4.\n"
                    + "Pretend to allocate requested resources to Pi by modifying the state as follows:        \n"
                    + "*** available = available - request_i\n"
                    + "*** allocation[i] = allocation[i] + request_i\n"
                    + "*** need[i] = need[i] - request_i   ");

            // available = available - request_i
            for (int j = 0; j < m; j++) {
                available[j] -= request_i[j];
            }

            //allocation[i] = allocation[i] + request_i
            for (int j = 0; j < m; j++) {
                allocation[i][j] += request_i[j];
            }

            // need[i] = need[i] - request_i  
            for (int j = 0; j < m; j++) {
                need[i][j] -= request_i[j];
            }

            System.out.println("\nAvailable,Max,Allocation,Need after granting the request: " + Arrays.toString(request_i) + " to process P" + i + ": ");
            printMatrix();

            //Now Step 5: Safety Algorithm: Check whether the resulting state is safe or not:
            System.out.println("Now Step 5: Safety Algorithm: Check whether the resulting state is safe or not:\n");

            flag = safetyAlgorithm();
        }

        return flag;
    }// end method

    public static void main(String[] args) {

        int n = 5, m = 3;
        // n is the # of processes P & m is the number of resource types R

        int[] available = new int[]{3, 3, 2};

        int[][] max = new int[][]{
            {7, 5, 3},
            {3, 2, 2},
            {9, 0, 2},
            {2, 2, 2},
            {4, 3, 3}
        };

        int[][] allocation = new int[][]{
            {0, 1, 0},
            {2, 0, 0},
            {3, 0, 2},
            {2, 1, 1},
            {0, 0, 2}
        };

        BankersAlgorithm b = new BankersAlgorithm(n, m, max, allocation, available);

        //The least example in week 13 Lecture 1:
        int[] request_i = new int[]{0, 2, 0};  // a request from process P1 (1,0,2)

        b.deadlock_avoidance(request_i, 4);
        
        

        
    }// end main

}// end class

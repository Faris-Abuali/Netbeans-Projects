package fibonacci;

import java.util.Arrays;

/**
 *
 * @author Fares Abu Ali
 */
public class Fibonacci {
    // 0, 1, 2, 3, 4, 5, 6, 7 , 8 , 9 , 10, 11, 12,  13
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233

    private static long ar[];
    private long startTime, finishTime;

    public long[] getArray() {
        return ar;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getFinishTime() {
        return finishTime;
    }
    
    public long getElapsedTime(){
        return finishTime-startTime;
    }

    //-------------------------3rd Way: MEMOIZATION-----------------------------------//
    public long fiboMemoization(int index) {

        long result = 0;

        if (index < 0) {
            throw new RuntimeException("Invalid Index, index=" + index);
        } 
        else if (index == 0) {
            result = 0;
        }
        else {

            ar = new long[index + 1];

            startTime = System.currentTimeMillis();
            result = fiboMemo(index);
            finishTime = System.currentTimeMillis();
        }

        return result;
    }

    private long fiboMemo(int index) {

        if (ar[index] == 0) {

            // this means that we still haven't calculated the ith term
            if (index == 1 || index == 2) {
                ar[index] = 1;
            } 
            else {

                ar[index] = fiboMemo(index - 1) + fiboMemo(index - 2);
            }

        }
        
        return ar[index];
        
    }// end method

    //-------------------------------------------------------------------------------//
    //----------------------------2nd Way: Previous and Current-----------------------------------------//
    public long fiboCuurentPrevious(int index) {

        long result = 0;

        if (index < 0) {
            throw new RuntimeException("Invalid Index, index=" + index);
        } else if (index == 0) {

            result = 0;
        } else {

            startTime = System.currentTimeMillis();
            result = fibo(0, 1, index);
            finishTime = System.currentTimeMillis();

        }

        return result;
    }

    private long fibo(long prev, long curr, int index) {

        if (index == 1) {
            return curr;
        }

        return fibo(curr, curr + prev, index - 1);

    }

    //-------------------------------------------------------------------------------//
    //--------------------------1st Way: Regular Fibonacci----------------------------------------//
    public long fibonacciRegular(int index) {

        long result;

        if (index < 0) {
            throw new RuntimeException("Invalid Index, index=" + index);
        }

        startTime = System.currentTimeMillis();
        result = fibonacci(index);
        finishTime = System.currentTimeMillis();
        
        return result;

    }

    private long fibonacci(int index) {

        if (index < 2) {
            return index;
        }

        return fibonacci(index - 1) + fibonacci(index - 2);
    }

}// end class

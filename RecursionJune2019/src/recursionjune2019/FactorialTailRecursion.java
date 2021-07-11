package recursionjune2019;

/**
 *
 * @author Fares Abu Ali
 */
public class FactorialTailRecursion {

    
    public static int fact(int n) {
        return fact(n, 1);
    }

    public static int fact(int n, int result) {
        if (n == 1) {
            return result;
        }
        return fact(n - 1, result * n);
    }

    
       //index: 0 1 2 3 4 5 6 7  8  9  10 11  12
       //value: 0 1 1 2 3 5 8 13 21 34 55 89 144 
    
    
    
    
    // this is called (tail recursion): There is no pending operation after a call is returned. 
    public static int fib(int n) {
        // 0 1 2 3 4 5 6 7  8  9  10 11  12
        // 0 1 1 2 3 5 8 13 21 34 55 89 144 
        if (n < 2) {
            return n;
        }
        
        return fib(n - 1) + fib(n - 2);
        
    }
    
    public static int fibTail(int n) {
        return helperFibTail(n,0,1);
    }
    
    public static int helperFibTail(int n,int prev,int next){
        
        if(n==0)
            return next; // return next; if you consider the series as :    0 1 1 2 3 5 8...
                         // or return prev; if you consider the series as:  1 1 2 3 5 8 13...
        else{
            
            int temp=prev;
            prev=next;
            next=temp+next;
            
            
            return helperFibTail(n-1,prev,next);
           
        }
    }
    
  
            
    
    public static int fiboArray(int index) {
        
        if (index == 0) {
            return 0;
        } else {
            int[] a = new int[index + 1];
            a[0] = 0;
            a[1] = 1;
            
            for (int i = 2; i < index + 1; i++) {
                a[i] = a[i - 1] + a[i - 2];
            } 
            
        return a[index];
        }
        
    }
    
    
    
    public static void main(String[] args) {
        System.out.println(fiboArray(10));
        System.out.println(fibTail(10));
    }

    //EndOfClass
}

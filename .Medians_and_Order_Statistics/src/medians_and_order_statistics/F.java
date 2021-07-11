/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medians_and_order_statistics;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class F {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        int c = sc.nextInt();
        
        
        int[] ar = new int[n];
        
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }
        
        
        
        //System.out.println(Arrays.toString(ar));
        
        int ctr=0;
        for(int i=0;i<=ar.length-c;i++){
            
            int[] sub =Arrays.copyOfRange(ar, i, i+c);
            
            
            boolean ok=true;
            
            for(int j=0;j<sub.length;j++){
                if(sub[j]>t){
                    ok=false;
                    break;
                }
            }
            
            if(ok){
                ctr++;
            }
        }
        
        
        System.out.println(ctr);

    }// end main
}// end class

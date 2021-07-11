/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carspark;

import carspark.CarSpark.Reservation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Fares Abu Ali
 */
public class CarSpark {
    
    static class Reservation implements Comparator<Reservation> {

        int Bs, Be, Ai;

        public Reservation() {

        }
        public Reservation(int Bs, int Be, int Ai) {

            this.Bs = Bs;
            this.Be = Be;
            this.Ai = Ai;
        }
       public int getAi() {
            return this.Ai;
        }
 
        @Override
        public int compare(Reservation o1, Reservation o2) {

            if (o1.Ai > o2.Ai) {
                return 1;
            } else if (o1.Ai < o2.Ai) {
                return -1;
            } else {
                return 0;
            }
        }
    }// end class

    public static void main(String[] args) {
        
        ArrayList<Integer> output = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int T;
        T = sc.nextInt();

        int N;
        int sum = 0;

        while (T > 0) {

            N = sc.nextInt();
            sum = 0;

            ArrayList<Reservation> arList = new ArrayList<>();
            //Reservation[] ar = new Reservation[N];

            int Bs, Be, Ai;

            for (int i = 0; i < N; i++) {

                Bs = sc.nextInt();
                Be = sc.nextInt();
                Ai = sc.nextInt();

                arList.add(new Reservation(Bs, Be, Ai));

            }

            Collections.sort(arList, new Reservation());

            //===========================
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i <= 48; i++) {
                set.add(i);
            }
            //===========================

            for (int i = arList.size() - 1; i >= 0; i--) {

                Reservation r = arList.get(i);

                boolean compatible = true;

                for (int t = r.Bs; t < r.Be; t++) {
                    if (!set.contains(t)) {
                        compatible = false;
                        break;
                    }
                }

                if (compatible) {

                    sum += r.Ai;

                    for (int t = r.Bs; t < r.Be; t++) {
                        set.remove(t);
                    }
                }// end if
            }

           // System.out.println("for this N: Sum = " + sum);
           
           output.add(sum);
//            System.out.println("ArrayList :" + arList);
//
//
//            System.out.println("ArrayList :" + arList);
//
//            for (int i = 0; i < arList.size(); i++) {
//                System.out.println(arList.get(i).toString());
//            }
            T--;
        }
        
        
        
        
        for(int i=0;i<output.size();i++){
            System.out.println(output.get(i));
        }

    }// end main

}

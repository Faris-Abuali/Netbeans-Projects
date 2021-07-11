/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphapril;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/**
 *
 * @author Fares Abu Ali
 */
public class TimeStamp {

    /*
    d[v] = discovery time (v turns from white to gray)
    f[v] = finishing time (v turns from gray to black)

     */
    private int d, f; //discovery time, finish time

    public TimeStamp() {

    }

    public TimeStamp(int d, int f) {
        this.d = d;
        this.f = f;
    }

    public void setD(int d) {
        this.d = d;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getD() {
        return this.d;
    }

    public int getF() {
        return this.f;
    }

    public String toString() {

        return "(d = " + d + ", f = " + f + ")";

    }

    public <E> ArrayList<Pair<E>> sortDFSTimeListInOrderOfDecreasingFinishTimes(Map<E, TimeStamp> timeList) {

        // this is necessary in StronglyConnectedComponents Algorithm
        ArrayList<Pair<E>> arlist = new ArrayList<>();

        for (E currKey : timeList.keySet()) {
            arlist.add(new Pair(currKey, timeList.get(currKey).getF()));
        }

        Collections.sort(arlist, new TimeSorter());

        return arlist;
    }// end method

    public <E> ArrayList<Pair<E>> sortDFSTimeListInOrderOfIncreasingFinishTimes(Map<E, TimeStamp> timeList) {

        // this is necessary in StronglyConnectedComponents Algorithm
        ArrayList<Pair<E>> arlist = new ArrayList<>();

        for (E currKey : timeList.keySet()) {
            arlist.add(new Pair(currKey, timeList.get(currKey).getF()));
        }

        Collections.sort(arlist, new TimeSorter().reversed());

        return arlist;
    }// end method

    public <E> void printTimeList(Map<E, TimeStamp> timeList) {

        System.out.println("------------------------------------------------");
        System.out.println("d = Discovery Time\nf = Finish Time");
        System.out.println("Vertex\td\tf");

        for (E currKey : timeList.keySet()) {

            System.out.print(" " + currKey + "\t" + timeList.get(currKey).getD() + "\t" + timeList.get(currKey).getF() + "\n");

        }
    }

}// end class

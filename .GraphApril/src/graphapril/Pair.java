/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class Pair<E> {

    E key;
    int finishTime;

    public Pair(E key, int finishTime) {
        this.key=key;
        this.finishTime=finishTime;
    }

    public String toString() {

        return "(" + key + "," + "FinishTime=" + finishTime + ")";
    }

}//end class

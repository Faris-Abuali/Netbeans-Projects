/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphapril;

import java.util.*;

/**
 *
 * @author Fares Abu Ali
 */
public class TimeSorter implements Comparator<Pair> {


    @Override
    public int compare(Pair o1, Pair o2) {
        
        if(o2.finishTime>o1.finishTime){
            return 1;
        }
        else if(o2.finishTime<o1.finishTime){
            return -1;
        }
        return 0;
    }

}// end class

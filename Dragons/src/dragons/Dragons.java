
package dragons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Fares Abu Ali
 */
public class Dragons {

  
    static class Pair implements Comparator<Pair> {

        int x, y;

        public Pair() {

        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {

            StringBuilder builder = new StringBuilder("");

            builder.append("(" + this.x + ", " + this.y + ")");

            return builder.toString();
        }

        @Override
        public int compare(Pair o1, Pair o2) {

            if (o1.y > o2.y) {
                return -1;
            } else if (o2.y > o1.y) {
                return 1;
            }
            return 0;
        }

    }// end class

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Pair> arList = new ArrayList<>();


        int s, n;

        s = sc.nextInt();  // Krito's Strength
        n = sc.nextInt(); // # of dragons

        int x, y;

        int myStrngth = s;

        while (n > 0) {

            x = sc.nextInt(); // ith dragon's Strength
            y = sc.nextInt(); // the bonus you get if you win

            arList.add(new Pair(x, y));

            n--;
        }

        
       //System.out.println(arList);
        
        Collections.sort(arList, new Pair());

        //System.out.println(arList);
        
        for(int i=0;i<arList.size();i++){
            
            Pair p =arList.get(i);
            
            if(myStrngth>p.x){
                myStrngth+=p.y;
                arList.remove(p);
                i=-1;
            }
            
        }
        
        if(arList.isEmpty()){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        
        
        
    }// end main
    
}

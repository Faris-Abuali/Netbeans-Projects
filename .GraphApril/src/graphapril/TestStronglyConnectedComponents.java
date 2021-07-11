package graphapril;

import java.util.Map;

/**
 *
 * @author Fares Abu Ali
 */
public class TestStronglyConnectedComponents {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("a", "b", true, 4);
        gr.addEdge("e", "a", true, 25);
        gr.addEdge("b", "e", true, 3);
        gr.addEdge("e", "f", true, 6);
        gr.addEdge("b", "f", true, 12);

        gr.addEdge("b", "c", true, 9);
        gr.addEdge("f", "g", true, 3);
        gr.addEdge("g", "f", true, 4);

        gr.addEdge("c", "g", true, 2);
        gr.addEdge("c", "d", true, 13);
        gr.addEdge("d", "c", true, 24);
        gr.addEdge("g", "h", true, 50);
        gr.addEdge("d", "h", true, 60);
        gr.addEdge("h", "h", true, 5);

        gr.printAdjListWithWeights();

        DFS_Attributes<String> dfs = gr.DFS("d", true);
//
        System.out.println("DFS: " + dfs.outputSet);
//        
        Map<String, TimeStamp> timeList = dfs.timeList;
//        
//       // System.out.println(timeList);
        new TimeStamp().printTimeList(timeList);

       // System.out.println(new TimeStamp().sortDFSTimeListInOrderOfDecreasingFinishTimes(timeList));

        System.out.println( gr.STRONGLY_CONNECTED_COMPONENTS("c", true) ); // start from (d)
        
        gr.sumOfWeightsOfStronglyConnectedComponents();
      
// ---------- Another Example -----------------------
//        gr.addEdge("0", "1", true, 0);
//        gr.addEdge("1", "2", true, 0);
//        gr.addEdge("2", "3", true, 0);
//        gr.addEdge("3", "0", true, 0);
//        gr.addEdge("2", "4", true, 0);
//        gr.addEdge("4", "5", true, 0);
//        gr.addEdge("5", "6", true, 0);
//        gr.addEdge("6", "4", true, 0);
//        gr.addEdge("7", "6", true, 0);
//        gr.addEdge("7", "8", true, 0);
//
//         gr.printAdjListWithWeights();
//
//        DFS_Attributes<String> dfs = gr.DFS("0", true);
//
//        System.out.println(dfs.outputSet);
//        
//        Map<String,TimeStamp> timeList = dfs.timeList;
//        
//        System.out.println(timeList);
//        System.out.println(new TimeStamp().sortDFSTimeListInOrderOfIncreasingFinishTimes(timeList));
//        gr.STRONGLY_CONNECTED_COMPONENTS("0", true);
//

   //     

    }// end main

}//end class

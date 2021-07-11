package graphapril;

/**
 *
 * @author Fares Abu Ali
 */
public class Huth {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>();

        gr.addEdge("A", "B", true, 4);
        gr.addEdge("A", "C", true, 4);
        gr.addEdge("D", "A", true, 3);
        gr.addEdge("D", "C", true, 2);
        gr.addEdge("C", "E", true, 4);
        gr.addEdge("E", "D", true, 1);

        gr.addEdge("C", "F", true, -2);
        gr.addEdge("F", "E", true, -3);
        gr.addEdge("G", "F", true, 2);

        gr.addEdge("E", "G", true, -2);
        gr.addEdge("G", "H", true, 2);
        gr.addEdge("H", "E", true, -2);
        gr.addEdge("F", "B", true, 3);
        
        
       gr.printAdjListWithWeights();
        
      
        DFS_Attributes<String> dfs = gr.DFS("A", true);
        
        
        System.out.println("DFS: "+dfs.outputSet);
        
        
        new TimeStamp().printTimeList(dfs.timeList);
        
        
       // System.out.println(  new TimeStamp().sortDFSTimeListInOrderOfDecreasingFinishTimes(dfs.timeList) );
       
       
        System.out.println(gr.STRONGLY_CONNECTED_COMPONENTS("A", true));
        

    }// end main

}// end class

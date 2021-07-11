package graphapril;

/*
 * @author Fares Abu Ali
 */
public class MoodleDiscussion {

    public static void main(String[] args) {

        GraphApril<String> gr = new GraphApril<>(); // this is my class

        gr.addEdge("u", "v", true, 0); // (source, destination, isDirected?, weight)
        gr.addEdge("u", "x", true, 0);
        gr.addEdge("x", "v", true, 0);
        gr.addEdge("v", "y", true, 0);
        gr.addEdge("y", "x", true, 0);
        gr.addEdge("w", "y", true, 0);
        gr.addEdge("w", "z", true, 0);
        gr.addEdge("z", "z", true, 0);

        gr.printAdjListWithWeights();

        DFS_Attributes<String> dfs = gr.DFS("u", true); // let the source be (u)

        System.out.println("When (u) is the sourceVertex: ");
        System.out.println(dfs.outputSet);

        DFS_Attributes<String> dfs2 = gr.DFS("z", true);// let the source be (z)
        System.out.println("\nWhen (z) is the sourceVertex: ");

        System.out.println(dfs2.outputSet);

    }// end main
}// end class


public class GraphDriver {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addDirectedEdge(0, 1);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(3, 4);
        graph.addDirectedEdge(2, 3);
        graph.addDirectedEdge(4, 0);
        graph.addDirectedEdge(4, 1);
        graph.addDirectedEdge(4, 5);
        graph.printGraph();
        graph.DFS();
    }
}
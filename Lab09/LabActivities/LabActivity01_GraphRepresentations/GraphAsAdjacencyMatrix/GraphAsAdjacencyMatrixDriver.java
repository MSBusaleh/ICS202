public class GraphAsAdjacencyMatrixDriver {
    public static void main(String[] args) {
        GraphAsAdjacencyMatrix graph1 = new GraphAsAdjacencyMatrix(5);
        System.out.println("Graph1:");
        graph1.addDirectedEdge(0, 1);
        graph1.addDirectedEdge(0, 4);
        graph1.addDirectedEdge(1, 2);
        graph1.addDirectedEdge(1, 3);
        graph1.addDirectedEdge(1, 4);
        graph1.addDirectedEdge(2, 3);
        graph1.addDirectedEdge(3, 4);
        graph1.printGraph();
        
        System.out.println("---------------------------------------------------");
        System.out.println("Graph2:");
        GraphAsAdjacencyMatrix graph2 = new GraphAsAdjacencyMatrix(5);
        graph2.addUndirectedEdge(0, 1);
        graph2.addUndirectedEdge(0, 4);
        graph2.addUndirectedEdge(1, 2);
        graph2.addUndirectedEdge(1, 3);
        graph2.addUndirectedEdge(1, 4);
        graph2.addUndirectedEdge(2, 3);
        graph2.addUndirectedEdge(3, 4);
        graph2.printGraph();
    }
}

public class GraphAsAdjacencyListDriver2{
    public static void main(String[] args) {
        GraphAsAdjacencyList2 graph1 = new GraphAsAdjacencyList2(5);
        graph1.addDirectedEdge('A', 'B');
        graph1.addDirectedEdge('A', 'E');
        graph1.addDirectedEdge('B', 'C');
        graph1.addDirectedEdge('B', 'D');
        graph1.addDirectedEdge('B', 'E');
        graph1.addDirectedEdge('C', 'D');
        graph1.addDirectedEdge('D', 'E');
        System.out.println("The adjacency list for the directed graph1: ");
        graph1.printGraph();
        System.out.println("------------------------------");
        
        GraphAsAdjacencyList2 graph2 = new GraphAsAdjacencyList2(5);
        graph2.addUndirectedEdge('A', 'B');
        graph2.addUndirectedEdge('A', 'E');
        graph2.addUndirectedEdge('B', 'C');
        graph2.addUndirectedEdge('B', 'D');
        graph2.addUndirectedEdge('B', 'E');
        graph2.addUndirectedEdge('C', 'D');
        graph2.addUndirectedEdge('D', 'E');
        System.out.println("The adjacency list for the undirected graph2: ");
        graph2.printGraph();
    }
}
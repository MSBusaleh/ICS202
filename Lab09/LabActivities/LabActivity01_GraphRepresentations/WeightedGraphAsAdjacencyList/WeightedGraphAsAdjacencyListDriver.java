public class WeightedGraphAsAdjacencyListDriver{
public static void main(String[] args) {
            int vertices = 6;
            WeightedGraphAsAdjacencyList graph1 = new WeightedGraphAsAdjacencyList(vertices);
            graph1.addDirectedEgde(0, 1, 4);
            graph1.addDirectedEgde(0, 2, 3);
            graph1.addDirectedEgde(1, 3, 2);
            graph1.addDirectedEgde(1, 2, 5);
            graph1.addDirectedEgde(2, 3, 7);
            graph1.addDirectedEgde(3, 4, 2);
            graph1.addDirectedEgde(4, 0, 4);
            graph1.addDirectedEgde(4, 1, 4);
            graph1.addDirectedEgde(4, 5, 6);
            System.out.println("Directed graph: ");
            graph1.printGraph();
            
            System.out.println("---------------------------------------------------------");
            
           WeightedGraphAsAdjacencyList graph2 = new WeightedGraphAsAdjacencyList(vertices);
            graph2.addUndirectedEgde(0, 1, 4);
            graph2.addUndirectedEgde(0, 2, 3);
            graph2.addUndirectedEgde(1, 3, 2);
            graph2.addUndirectedEgde(1, 2, 5);
            graph2.addUndirectedEgde(2, 3, 7);
            graph2.addUndirectedEgde(3, 4, 2);
            graph2.addUndirectedEgde(4, 0, 4);
            graph2.addUndirectedEgde(4, 1, 4);
            graph2.addUndirectedEgde(4, 5, 6);
            System.out.println("Undirected graph: ");
            graph2.printGraph();
        }
}
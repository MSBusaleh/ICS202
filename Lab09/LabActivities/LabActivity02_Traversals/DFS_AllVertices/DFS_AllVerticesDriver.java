public class DFS_AllVerticesDriver {
    public static void main(String[] args) {
        int vertices = 7;
        DFS_AllVertices graph = new DFS_AllVertices(vertices);
        /*
        graph.addDirectedEgde(1,3);
        graph.addDirectedEgde(2,3);
        graph.addDirectedEgde(0,4);
        graph.addDirectedEgde(4,5);
        graph.addDirectedEgde(5,6);
        graph.DFSRecursion();
        
        */
        graph.addDirectedEdge(0,4);
        graph.addDirectedEdge(4,5);
        graph.addDirectedEdge(5,6);
        graph.addDirectedEdge(6,3);
        graph.addDirectedEdge(3,2);
        graph.addDirectedEdge(2,1);
        graph.addDirectedEdge(1,0);
        graph.DFSRecursion();
        
    }
}
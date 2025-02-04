public class GraphDriver{ 
    public static void main(String[] args) { 
        // Total 5 vertices in graph 
        Graph g = new Graph(5); 
          
        g.addDirectedEdge(1, 0); 
        g.addDirectedEdge(0, 2); 
        g.addDirectedEdge(2, 1); 
        g.addDirectedEdge(0, 3); 
        g.addDirectedEdge(1, 4); 
              
        System.out.println("The following is the Depth First Traversal starting from vertex 0: "); 
        g.DFS(0); 
    } 
} 

public class GraphDriver{
    public static void main(String args[]) 
    { 
       Graph g = new Graph(9); 
  
        g.addDirectedEdge(0, 1); 
        g.addDirectedEdge(0, 3);
        g.addDirectedEdge(0, 4); 
        
        g.addDirectedEdge(1, 2); 
        g.addDirectedEdge(1, 4);
         
        g.addDirectedEdge(2, 5); 
        g.addDirectedEdge(3, 6);
        g.addDirectedEdge(6, 7);
        g.addDirectedEdge(7, 8);
          
        System.out.println("The following is the Breadth First Traversal "+ 
                           "(starting from vertex 0):"); 
        g.BFS(0); 
        System.out.println("\nThe following is the Depth First Traversal "+ 
                           "(starting from vertex 0): "); 
        g.DFS(0);  
    } 
} 
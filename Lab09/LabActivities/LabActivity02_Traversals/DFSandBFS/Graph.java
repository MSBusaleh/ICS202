// BFS(int s) traverses vertices reachable from s. 
// DFS(int s) traverses vertices reachable from s. 
import java.util.LinkedList; 
import java.util.Iterator;
  
// This class represents a directed graph using adjacency list
class Graph { 
    private int numberOfVertices;    
    private LinkedList<Integer> adj[]; //Adjacency Lists 
  
    Graph(int numberOfVertices) { 
        this.numberOfVertices= numberOfVertices; 
        adj = new LinkedList[numberOfVertices]; 
        for (int i = 0; i < numberOfVertices; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    // Function to add a directed edge into the graph 
    void addDirectedEdge(int v,int w) { 
        adj[v].add(w); 
    }
    
     // Function to add an undirected edge into the graph 
    void addUndirectedEdge(int v,int w) { 
        adj[v].add(w); 
        adj[w].add(v); 
    } 
  
    // prints BFS traversal from a given source s 
    void BFS(int s) { 
        // Mark all the vertices as not visited(By default set as false) 
        boolean visited[] = new boolean[numberOfVertices]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s + " "); 
  
            /* Get all adjacent vertices of the dequeued vertex s 
                If a adjacent has not been visited, then mark it 
                visited and enqueue it.
            */ 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) { 
                int vertex = i.next(); 
                if (!visited[vertex]) { 
                    visited[vertex] = true; 
                    queue.add(vertex); 
                } 
            } 
        } 
    } 
    
    // A function used by DFS 
    void DFSUtil(int currentVertex, boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[currentVertex] = true; 
        System.out.print(currentVertex + " "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[currentVertex].listIterator(); 
        while (i.hasNext()) 
        { 
            int vertex = i.next(); 
            if (!visited[vertex]) 
                DFSUtil(vertex, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int vertex) { 
        // Mark all the vertices as not visited(set as false by default in java) 
        boolean visited[] = new boolean[numberOfVertices]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(vertex, visited); 
    }  
} 
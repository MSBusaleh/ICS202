package Task03;

import java.util.*;

// Determines if a vertex is reachable from another vertex in a directed graph
public class Graph {
    private List<List<Integer>> adjList = null;
    private int numVertices;
 
    public Graph(List<Edge> edges, int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>();
 
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the directed graph
        for (Edge edge: edges){
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
        }
    }
  
    public boolean isReachable(int src, int dest){
        if(src >= numVertices || dest >= numVertices)
            throw new RuntimeException("vertex out of boundaries");

      boolean[] visited = new boolean[numVertices];
      return isReachable(src, dest, visited);
    }
    
    // Function to perform BFS traversal from the source vertex in the graph to
    // determine if the destination vertex is reachable from the source or not
    private boolean isReachable(int src, int dest, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int child : adjList.get(currentVertex)) {
                if (child == dest)
                    return true;

                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        return false;
    }
}
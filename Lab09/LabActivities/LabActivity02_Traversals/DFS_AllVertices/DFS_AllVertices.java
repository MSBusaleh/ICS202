import java.util.LinkedList;
public class DFS_AllVertices {
    //this code will work for disconnected graphs as well
        int numVertices;
        LinkedList<Integer> [] adjList;

        DFS_AllVertices(int numVertices){
            this.numVertices = numVertices;
            adjList = new LinkedList[numVertices];
            for (int i = 0; i < numVertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
         public void addDirectedEdge(int source, int destination){
            adjList[source].addFirst(destination);
         }
         
          public void addUndirectedEdge(int source, int destination){
            adjList[source].addFirst(destination);
            adjList[destination].addFirst(source);
         }

         public void DFSRecursion(){
             boolean [] visited = new boolean[numVertices];
             System.out.println("Depth-First Search: ");
             //visit from each node if not already visited
             for (int i = 0; i < numVertices ; i++) {
                 if(!visited[i]){
                     dfs(i, visited);
                 }
             }
         }

         public void dfs(int start, boolean [] visited){
             visited[start] = true;
             System.out.print(start + " ");
             for (int i = 0; i < adjList[start].size() ; i++) {
                 int vertex = adjList[start].get(i);
                 if(!visited[vertex])
                     dfs(vertex,visited);
             }
         }
  }
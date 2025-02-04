import java.util.LinkedList;
import java.util.Queue;

public class BFS_AllVertices {
   
        int numberOfvertices;
        LinkedList<Integer>[] adjList;

        public BFS_AllVertices(int numberOfvertices){
            this.numberOfvertices = numberOfvertices;
            adjList = new LinkedList[numberOfvertices];

            //initialize the lists
            for (int i = 0; i <numberOfvertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
       }
       
         public void addDirectedEdge(int source, int destination){
            adjList[source].addFirst(destination);
        }
        
        public void addUndirectedEdge(int source, int destination){
            //add forward edge
            adjList[source].addFirst(destination);
            //add back edge for undirected graph
            adjList[destination].addFirst(source);

        }

        public void BFS_AllVertices(){
            boolean [] visited = new boolean[numberOfvertices];
            Queue<Integer> queue = new LinkedList<>();
            System.out.println("BFS: ");
            for (int i = 0; i <numberOfvertices ; i++) {
                if(!visited[i]){
                    queue.add(i);

                    while(!queue.isEmpty()){

                        //get a vertex from queue
                        int vertex = queue.remove();
                        //mark the vertex visited
                        visited[vertex] = true;

                        //print the vertex
                        System.out.print(vertex + " ");

                        //add unvisited adjacent vertices
                        for (int j = 0; j < adjList[vertex].size() ; j++) {
                            int adjVertex = adjList[vertex].get(j);
                            if(!visited[adjVertex]) {
                                visited[adjVertex] = true;
                                queue.add(adjVertex);
                            }
                        }
                    }
                }
            }
        }
    }
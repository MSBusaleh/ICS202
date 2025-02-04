package Task04;

class Graph{
        int numVertices;
        int matrix[][];


        public Graph(int numVertices) {
            this.numVertices = numVertices;
            matrix = new int[numVertices][numVertices];
        }


        public void addEdge(int source, int destination, int weight) {
            //add edge
            matrix[source][destination]=weight;

            //add back edge for undirected graph
            matrix[destination][source] = weight;
        }

        //get the vertex with minimum distance which is not included in SPG
        int getMinimumVertex(boolean [] spg, int [] key){
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <numVertices ; i++) {
                if(spg[i]==false && minKey>key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        public void dijkstra_GetMinDistances(int sourceVertex){
            boolean[] SPG = new boolean[numVertices];
            int [] distance = new int[numVertices];
            int INFINITY = Integer.MAX_VALUE;


            //Initialize all the distances to infinity
            for (int i = 0; i <numVertices ; i++) {
                distance[i] = INFINITY;
            }


            //start from the vertex 0
            distance[sourceVertex] = 0;


            //create SPG
            for (int i = 0; i <numVertices ; i++) {
                //get the vertex with the minimum distance
                int vertex_U = getMinimumVertex(SPG, distance);

                SPG[vertex_U] = true;

                //iterate through all the adjacent numVertices of above vertex and update the keys
                for (int vertex_V = 0; vertex_V < numVertices ; vertex_V++) {
                    //check of the edge between vertex_U and vertex_V
                    if(matrix[vertex_U][vertex_V] > 0){
                        //check if this vertex 'vertex_V' already in SPG and
                        // if distance[vertex_V]!=Infinity


                        if(SPG[vertex_V]==false && matrix[vertex_U][vertex_V]!=INFINITY){                              
                            //check if distance needs an update or not
                            //means check total weight from source to vertex_V is less than
                            //the current distance value, if yes then update the distance


                            int newKey =  matrix[vertex_U][vertex_V] + distance[vertex_U];
                            if(newKey<distance[vertex_V])
                                distance[vertex_V] = newKey;
                        }
                    }
                }
            }
            //print shortest path graph
            printDijkstra(sourceVertex, distance);
        }


        public void printDijkstra(int sourceVertex, int [] key){
            System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
            for (int i = 0; i <numVertices ; i++) {
                System.out.println("Source Vertex: " + sourceVertex + " to vertex " +   + i +
                        " distance: " + key[i]);
            }
        }
    }

public class DijkstraAdjacencyMatrix {
    public static void main(String[] args) {
         // To be completed by students
    
    }
}
public class GraphAsAdjacencyMatrix {
    int vertex;
    int matrix[][];

    public GraphAsAdjacencyMatrix(int vertex) {
        this.vertex = vertex;
        matrix = new int[vertex][vertex];
    }

    public void addDirectedEdge(int source, int destination) {    
        matrix[source][destination] = 1;         //add edge:  source ---> destination
    }
    
    
     public void addUndirectedEdge(int source, int destination) {      
        matrix[source][destination] = 1;       //add edge:   source ---> destination
        matrix[destination][source] = 1;       //add edge:   destination ---> sorce
    }

    public void printGraph() {
        System.out.println("Graph Adjacency Matrix: ");
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j <vertex ; j++) { 
                System.out.print(matrix[i][j]+ "   ");
            }
            System.out.println();
        }
        for (int i = 0; i < vertex; i++) {
            System.out.print("Vertex " + i + " is connected to each of vertices: [ ");
            for (int j = 0; j <vertex ; j++) {
                if(matrix[i][j] == 1){
                    System.out.print(j + "  ");
                }
            }
            System.out.println("]");
        }
    }
 }
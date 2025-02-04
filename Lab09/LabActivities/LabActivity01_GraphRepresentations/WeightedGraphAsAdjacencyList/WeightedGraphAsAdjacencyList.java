import java.util.LinkedList;

public class WeightedGraphAsAdjacencyList {
    private class Edge {
        private int source;
        private int destination;
        private int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }
        private int numVertices;
        private LinkedList<Edge> [] adjacencylist;

        public WeightedGraphAsAdjacencyList(int numVertices) {
            this.numVertices = numVertices;
            adjacencylist = new LinkedList[numVertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < numVertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addDirectedEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge); 
        }
        
         public void addUndirectedEgde(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            adjacencylist[source].addFirst(edge);
            
            edge = new Edge(destination, source, weight);
            adjacencylist[destination].addFirst(edge);  
        }

        public void printGraph(){
            for (int i = 0; i < numVertices ; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("vertex" + i + " is connected to " +
                            list.get(j).destination + " with weight " +  list.get(j).weight);
                }
            }
        }
    }
      
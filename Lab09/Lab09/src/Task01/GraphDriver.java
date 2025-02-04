package Task01;

public class GraphDriver{
    public static void main(String[] args){

        Graph myGraph = new Graph(4);

        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(1,3);
        myGraph.addEdge(2,3);


    System.out.println("Before deleting edge 2---3 the graph is: \n");
    myGraph.displayGraph();
    System.out.println("\n\n");

    myGraph.removeEdge(2,3);
    System.out.println("After deleting edge 2---3 the graph is: \n");
    myGraph.displayGraph();

    
  }
}
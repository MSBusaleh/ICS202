import java.util.LinkedList;
// NOTE THE REPRESENTATION GIVEN HERE IS NOT GOOD BECAUSE THE CHARACTER LABELS ARE HARD CODED
// A BETTER REPRESENTATION IS THAT REQUIRED IN TASK 02
public class GraphAsAdjacencyList2 {
    int numVertices;
    LinkedList<Character> list[];

    public GraphAsAdjacencyList2(int numVertices) {
        this.numVertices = numVertices;
        list = new LinkedList[numVertices];
        for (int i = 0; i < numVertices ; i++) {
            list[i] = new LinkedList<>();
        }
    }
    
    public void addDirectedEdge(char source, char destination){ 
        int sourceIndex = source - 'A';
        Character dest = destination;
        list[sourceIndex].addFirst(dest);     //add edge:   source ----> destination
     }

    public void addUndirectedEdge(char source, char destination){     
          int sourceIndex = source - 'A';

        Character dest = destination;
        list[sourceIndex].addFirst(dest);     //add edge:   source ----> destination
        
        int destinationIndex = destination - 'A';
        Character sc = source;
        list[destinationIndex].addFirst(sc);     // add edge:  destination ---> source
    }

    public void printGraph(){
        for (char i = 'A'; i < numVertices + 'A' ; i++) {
            System.out.println("Vertex" + i + " ----> " + list[i - 'A']);
        }
               
   }
}

    
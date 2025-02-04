
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    int numVertices;
    LinkedList<Integer> list[];

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        list = new LinkedList[numVertices];
        for (int i = 0; i <numVertices ; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addDirectedEdge(int source, int destination){
        list[source].addFirst(destination);
    }
    
     public void addUndirectedEdge(int source, int destination){
        list[source].addFirst(destination);
        list[destination].addFirst(source);
    }

    public void DFS(){
        System.out.print("Depth First Traversal: ");
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<Integer>();

        for(int startIndex = 0; startIndex < numVertices; startIndex++){
            if(! visited[startIndex]) {
                stack.push(startIndex);
                visited[startIndex] = true;
                while (! stack.isEmpty()) {
                    int nodeIndex = stack.pop();
                    System.out.print(nodeIndex + " ");
                    LinkedList<Integer> nodeList = list[nodeIndex];
                    for (int i = 0; i < nodeList.size(); i++) {
                        int dest = nodeList.get(i);
                        if (! visited[dest]) {
                            stack.push(dest);
                            visited[dest] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void printGraph(){
        for (int i = 0; i <numVertices ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(! nodeList.isEmpty()) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }
}
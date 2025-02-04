package Task03;

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class GraphDriver{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Edge> edges = Arrays.asList(Edge.getEdge(0, 3),  Edge.getEdge(1, 0),
                                             Edge.getEdge(1, 2),  Edge.getEdge(1, 4),
                                             Edge.getEdge(2, 7),  Edge.getEdge(3, 4),
                                             Edge.getEdge(3, 5), Edge.getEdge(4, 3),
                                             Edge.getEdge(4, 6), Edge.getEdge(5, 6),
                                             Edge.getEdge(6, 7));
 

        int numVertices = 8;
        Graph graph = new Graph(edges, numVertices);


        int src, dest;
        System.out.print("\nEnter the source from [0--7]:  ");
        src = scanner.nextInt();
        System.out.print("Enter the destination from [0--7]:  ");
        dest = scanner.nextInt();

        if(graph.isReachable(src, dest))
            System.out.println("\nYou can reach " + dest + " from " + src);
        else
            System.out.println("\nYou can't reach " + dest + " from " + src);
    }
}
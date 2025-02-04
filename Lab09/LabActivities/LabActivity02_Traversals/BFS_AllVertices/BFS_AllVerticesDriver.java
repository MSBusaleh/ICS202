
public class BFS_AllVerticesDriver {  
    public static void main(String[] args) {
        BFS_AllVertices g = new BFS_AllVertices(9);
        g.addUndirectedEdge(0, 1);
         g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(0, 4);
        g.addUndirectedEdge(1, 2);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 5);
        g.addUndirectedEdge(3, 6);
        g.addUndirectedEdge(6, 7);
        g.addUndirectedEdge(7, 8);
        g.BFS_AllVertices();
    }
}
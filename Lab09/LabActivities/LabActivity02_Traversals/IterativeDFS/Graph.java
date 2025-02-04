//An Iterative Java program to do DFS traversal from 
//a given source vertex. DFS(int s) traverses vertices 
//reachable from s. 
  
import java.util.*; 
  
public class Graph { 

        int numVertices;        
          
        LinkedList<Integer>[] adjLists; 
           
        Graph(int numVertices) 
        { 
            this.numVertices = numVertices; 
            adjLists = new LinkedList[numVertices]; 
              
            for (int i = 0; i < adjLists.length; i++) 
                adjLists[i] = new LinkedList<Integer>(); 
              
        } 
          
        void addDirectedEdge(int v, int w) 
        { 
            adjLists[v].add(w); // Add w to v’s list. 
        }
        
          void addUndirectedEdge(int v, int w) 
        { 
            adjLists[v].add(w); // Add w to v’s list. 
            adjLists[w].add(v); // Add w to v’s list. 
        } 
          
        // prints all not yet visited vertices reachable from s 
        void DFS(int s) 
        { 
            // Initially mark all vertices as not visited 
            Vector<Boolean> visited = new Vector<Boolean>(numVertices); 
            for (int i = 0; i < numVertices; i++) 
                visited.add(false); 
      
            // Create a stack for DFS 
            Stack<Integer> stack = new Stack<>(); 
              
            // Push the current source node 
            stack.push(s); 
              
            while(! stack.empty()) 
            { 
                // Pop a vertex from stack and print it 
                s = stack.peek(); 
                stack.pop(); 
                  
                // Stack may contain same vertex twice. So 
                // we need to print the popped item only 
                // if it is not visited. 
                if(! visited.get(s)) 
                { 
                    System.out.print(s + " "); 
                    visited.set(s, true); 
                } 
                  
                // Get all adjListsacent vertices of the popped vertex s 
                // If a adjListsacent has not been visited, then push it 
                // to the stack. 
                Iterator<Integer> itr = adjLists[s].iterator(); 
                  
                while (itr.hasNext())  
                { 
                    int v = itr.next(); 
                    if(!visited.get(v)) 
                        stack.push(v); 
                } 
                  
            } 
        } 
 } 

import java.util.*; 

class Graph { 
        int numVertices; 
          
        LinkedList<Integer>[] adjacencyList;      
          
        Graph(int numVertices) { 
            this.numVertices = numVertices; 
            adjacencyList = new LinkedList[numVertices]; 
              
            for (int i = 0; i < adjacencyList.length; i++) 
                adjacencyList[i] = new LinkedList<Integer>(); 
              
        } 
          
        //To add a directed edge to graph 
        void addDirectedEdge(int v, int w)  { 
            adjacencyList[v].add(w); // Add w to v’s list. 
        }

         //To add undirected edge to graph 
        void addUndirectedEdge(int v, int w) {          
            adjacencyList[v].add(w); 
            adjacencyList[w].add(v);                
        } 
        
        void displayGraph(){
           for (int i = 0; i < adjacencyList.length; i++){  
               System.out.println(i + " ----> " + adjacencyList[i]);
            } 
            System.out.println(); 
        
       } 
   }


package Code.Advanced.Graph;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Graph implementation based on Adjacency List or Adjacency Map ->
 * i.e HashMap with source & list of nodes
 * Directed traversal is O(V + E)
 * Undirected traversal is O(V + 2E)
 *
 * Design Graph- make sure adjMap.keySet() will give all nodes in the graph
 * For that, addEdge should always add both source and destination to graph if not already present
 *
 *
 * */

public class Graph {
    // Could also use adj array instead of adjMap for ex when on 26 characters needed
    // eg: public LinkedList<Character>[] adjArr;
    // adjArr[c-'a'] gives the correct index of the array to which character c will be stored. The content returned will be the linkedlist at this index
    // (Initialise by keeping a new LL at all index;)


    public HashMap<GraphNode, LinkedList<GraphNode>> adjMap;
    boolean directed;

    public Graph(boolean directed){
        this.directed = directed;
        this.adjMap = new HashMap<GraphNode, LinkedList<GraphNode>>();
    }

    public void addEdge(GraphNode source, GraphNode destination, boolean directed) {
        //Always add source and destination in graph if not present,
        // irrespective fo directed or undirected
        //This makes sure that adjMap.keySet() will always give all nodes present in the graph !!!
        if(!adjMap.containsKey(source)) {
            adjMap.put(source, null);
        }
        //Adding destination also to make sure that adjMap.keySet() will always give all nodes present in the graph
        if(!adjMap.containsKey(destination)) {
            adjMap.put(destination, null);
        }
        addEdgeHelper(source,destination);
        if(!directed)
            addEdgeHelper(destination,source);
    }

    public void addEdgeHelper(GraphNode source, GraphNode destination) {
        if(adjMap.get(source)!=null) {
            adjMap.get(source).add(destination);
        }
        else{
            LinkedList<GraphNode> list = new LinkedList<>();
            list.add(destination);
            adjMap.put(source,list);
        }
    }

    public boolean hasEdge(GraphNode source, GraphNode destination){
        if(!adjMap.containsKey(source))
            return false;
        return adjMap.get(source).contains(destination);
    }

    public int size() {
        return adjMap.size();
    }
}

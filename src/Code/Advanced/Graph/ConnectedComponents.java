package Code.Advanced.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find all connected components
 *
 * */
public class ConnectedComponents {

    public List<List<GraphNode>> findConnectedComponents(Graph g) {
        List<List<GraphNode>> componentsList = new ArrayList<>();
        Set<GraphNode> visited = new HashSet<>();
        /*
        * a - b,c
        * b - d,e
        * c - f
        * e - null
        * f - null
        * j - m
        * */
        int count=0;
        //Need to check the full KeySet because some nodes maybe unconnetced and will be missed out in dfs/bfs in directed/undirected graphs both
        //Need to use keySet in bfs also.
        for(GraphNode node: g.adjMap.keySet()) {
            if(!visited.contains(node)) {
                List<GraphNode> nodesList = new ArrayList<>();
                dfs(g,visited,node, nodesList);
                componentsList.add(nodesList);
                count++;
            }
        }
        System.out.println("Number of connected components" + count);
        return componentsList;
    }

    //Call dfs only for unvisited nodes
    public void dfs(Graph g, Set<GraphNode> visited, GraphNode node,
                    List<GraphNode> nodesList ) {
            visited.add(node);
            nodesList.add(node);
            //check for null lists in directed graph
            if(g.adjMap.get(node)==null)
                return;
            for(GraphNode neighbour : g.adjMap.get(node)) {
               if(!visited.contains(neighbour)) {
                   dfs(g,visited,neighbour,nodesList);
               }
            }
    }

    //Works tested, only debug shows correct values printed, run is printing format wrong,
    // but alg works corretcly
    public static void main(String args[]) {

        // Create a graph given in the above diagram
        Graph g = new Graph(true);

        GraphNode g0 = new GraphNode("0");
        GraphNode g1 = new GraphNode("1");
        GraphNode g2 = new GraphNode("2");
        GraphNode g3 = new GraphNode("3");
        GraphNode g4 = new GraphNode("4");
        GraphNode g5 = new GraphNode("5");

        g.addEdge(g1,g0,true);
        g.addEdge(g2,g3,true);
        g.addEdge(g3,g4,true);
        g.addEdge(g3,g5,true);
        System.out.println(
                "Following are connected components");
        ConnectedComponents obj = new ConnectedComponents();
        List<List<GraphNode>> componentsList  = obj.findConnectedComponents(g);
        for(List<GraphNode> list : componentsList) {
            for (GraphNode node: list) {
                System.out.println(node.name + ",");
            }
            System.out.println("\n");
        }

    }
}

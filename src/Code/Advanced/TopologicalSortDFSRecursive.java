package Code.Advanced;

import Code.Advanced.Graph.Graph;
import Code.Advanced.Graph.GraphNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/topological-sorting/
 *
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices
 * such that for every directed edge uv, vertex u comes before v in the ordering.
 * Topological Sorting for a graph is not possible if the graph is not a DAG.
 *
 * Topological sort is for Directed Acyclic Grpahs. Doesnt work if not DAG.
 * Hence detect cycle if required.
 *
 * Uses:
 * Cycle detection in directed acyclic graph *
 * Course schedule order or Course schedule cycle
 * Data Serialization
 * Resolving dependancies in linkers
 *
 * **Similar to DFS, using recursion stack
 * Diff from DFs because: In DFs, we first print a vertex and then recurse. But
 * in top sorting here : 5-> 0 <-4 Here both 5 and 4 have to be printed before 0
 * So use a stack and reverse the order.
 *  In DFS, we start from a vertex, we first print it and then recursively call DFS for its adjacent vertices.
 *  In topological sorting, we use a temporary stack. We don’t print the vertex immediately,
 *  we first recursively call topological sorting for all its adjacent vertices, then push it to a stack.
 *  Finally, print contents of the stack. Note that a vertex is pushed to stack only when all of
 *  its adjacent vertices (and their adjacent vertices and so on) are already in the stack.
 *
 * Since it is just like DFs, TC is O(V+E)
 *
 *
 */
public class TopologicalSortDFSRecursive {

    //Assume there is no cycle
    public void findOrder(Graph g) {
        Set<GraphNode> visited = new HashSet<>();
        Set<GraphNode> cycleCheck = new HashSet<>();
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node: g.adjMap.keySet()) {
            if(!visited.contains(node)) {
                topologicalDFS(node, g, visited, stack);
                topologicalDFSWithCycleCheck(node,g,visited,stack,cycleCheck);
            }
        }
        //Print stack from top to bottom!
    }

    /** Similar to DFS, only difference is, dont add node immediately to result,
     * return from dfs recursion and then add in opposite order - so use stack*/
    public void topologicalDFS(GraphNode node, Graph g, Set<GraphNode> visited, Stack<GraphNode> stack) {
        if(!visited.contains(node)) {
            visited.add(node);
            //visit neighbours
            for(GraphNode neighbour: g.adjMap.get(node)) {
                if(neighbour!=null) {
                    topologicalDFS(neighbour,g,visited,stack);
                }
            }
            stack.push(node);
        }
    }
    //Need to test !!
    public boolean topologicalDFSWithCycleCheck(GraphNode node, Graph g, Set<GraphNode> visited, Stack<GraphNode> stack,
                                                Set<GraphNode> cycleCheck) {
        if (cycleCheck.contains(node))
            return false;
        else
            cycleCheck.add(node);
        if (!visited.contains(node)) {
            visited.add(node);
            //visit neighbours
            for (GraphNode neighbour : g.adjMap.get(node)) {
                if (neighbour != null) {
                    if(!topologicalDFSWithCycleCheck(neighbour, g, visited, stack, cycleCheck))
                        return false;
                }
            }
            stack.push(node);
            cycleCheck.remove(node);
        }
        return true;
    }
}



















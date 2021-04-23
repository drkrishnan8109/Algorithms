package Code.Advanced;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by drkrishnan on 01.04.2018.
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
 *
 * Since it is just like DFs, TC is O(V+E)
 *
 *
 */
public class TopologicalSort {

        //4, [[1,0],[2,0],[3,1],[3,2]]
    /*
    0
    1 0
    2 0
    3 1,2
    */
    /**
     * IMP :  Refer Graph Data structure: https://stackabuse.com/graphs-in-java-representing-graphs-in-code/
     * */

        class Graph {
            public LinkedList<Integer>[] adj;

            public Graph(int V) {
                adj = new LinkedList[V];
                for(int i=0;i<V;i++)
                    adj[i]= new LinkedList<Integer>();
            }

            public void addEdge(int v, int w){
                adj[v].add(w);
            }

            //cycleCheck acts as recursion stack
            //return value is true if cycle detected
            public boolean topologicalSort(int i, boolean[] visited, Stack<Integer> stack, boolean[] cycleCheck) {
                if(!visited[i]) {
                    visited[i]=true;
                    cycleCheck[i]=true;
                    Iterator<Integer> itr= adj[i].listIterator();
                    int j;
                    while(itr.hasNext()){
                        j=itr.next();
                        if(cycleCheck[j]) {
                            return true; //cycle present
                        }
                        else if(!visited[j]) {
                            if(topologicalSort(j,visited,stack,cycleCheck))
                                return true;
                        }
                    }
                    //push only when traversal ends
                    stack.push(i);
                }
                cycleCheck[i]=false;
                return false;
            }
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Graph G = new Graph(numCourses);

            for(int i=0;i<prerequisites.length;i++) {
                G.addEdge(prerequisites[i][1],prerequisites[i][0]);
            }

            boolean[] visited= new boolean[numCourses];
            boolean[] cycleCheck = new boolean[numCourses];
            Stack<Integer> stack = new Stack<>();

            int[] res= new int[numCourses];
            for(int i=0;i<numCourses;i++) {
                //IMP to return empty array if cycle exists
                if(G.topologicalSort(i,visited,stack,cycleCheck))
                    return new int[0];
            }

            int k=0;
            while(!stack.isEmpty()) {
                res[k]=stack.pop();
                k++;
            }
            return res;
        }
    }
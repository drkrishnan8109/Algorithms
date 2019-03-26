package Code.Advanced;

import java.util.LinkedList;

/**
 * Created by drkrishnan on 01.04.2018.
 *
 * All possible schedules or order
 * All topological sorts - using in degree
 *
 *
 *
 */
public class TopologicalSortII {
    LinkedList<Integer>[] adj;
    class Graph {
        int V,E;

        public Graph(int v, int e) {
            V=v;E=e;
            adj = new LinkedList[v];

            for(int i=0;i<e;i++) {
                adj[i]= new LinkedList<Integer>();
            }
        }


    }
    public void allTopoSort() {


    }
}

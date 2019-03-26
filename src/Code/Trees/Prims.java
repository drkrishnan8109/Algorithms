package Code.Trees;

/**
 * Created by Dhanya on 11/25/17.
 *
 * Find min path from one source vertex to all others
 * O(v2) for this alg since it uses graph matrix
 *
 */
public class Prims {

    public void findShortestDistance(int[][] graph, int n) {

        // dist[i] represents the weight connecting i to the vertices included in MST.
        //It is also called key assigned to this vertex
        int[] dist = new int[n];

        // sptSet[i] will be true if node i is included in the shortest path
        boolean[] sptSet = new boolean[n];

        //Parent array to store constructed mst
        int[] parent = new int[n];

        for(int i=1; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[0] = 0;
        parent[0]= -1;

        //Find shortest path for all the vertices
        for(int i=0; i<n; i++) {
            //Find the shortest distance vertex from the unincluded set of nodes
            //u is the vertex at min dist from source
            // when i=0, u is source and hence gets included in sptSet
            int u = minDistanceIndx(dist, sptSet);

            //Include it in selected set and mark as true
            sptSet[u] = true;

            //Update distance array only if
            // 1) v is not already in sptSet
            // 2) there is an edge from u to v
            // 3) u is not the default distance of infinity
            for(int v=0; v<n; v++) {
                if(sptSet[v]!= true && dist[u] != Integer.MAX_VALUE &&
                        graph[u][v] !=0 ) {
                    // The only 3 different steps than dijkstras
                    if(dist[v] > graph[u][v]) {
                        parent[v] = u;
                        dist[v] = graph[u][v];
                    }
                }
            }
        }
        // print the constructed distance array
        printMST(parent, n, graph);
    }

    //Should return the index of the node at min distance, not the min distance itself
    public int minDistanceIndx(int[] dist, boolean[] sptSet) {
        int minDist = Integer.MAX_VALUE;
        int n= dist.length;
        int minIndex = -1;

        for(int i=0; i<n; i++) {
            if(sptSet[i]==false && dist[i]<minDist) {
                minDist=dist[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int n, int graph[][])
    {
        System.out.println("Edge   Weight");
        for (int i = 1; i < n; i++)
            System.out.println(parent[i]+" - "+ i+"    "+
                    graph[i][parent[i]]);
    }

    // Driver method
    public static void main (String[] args)
    {
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Prims t = new Prims();
        t.findShortestDistance(graph,9);
    }
}

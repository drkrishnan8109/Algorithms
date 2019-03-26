package Code.Trees;

/**
 * Created by Dhanya on 11/26/17.
 *
 * O(n3)
 */
public class FloydWarshallAPSP {

    public static final int INF= Integer.MAX_VALUE;

    public void allPairShortestPath(int[][] graph, int n) {
        int[][] dist = new int[n][n];
        int i,j,k;

        for(i =0; i<n; i++) {
            for(j=0; j<n; j++)
            dist[i][j] = graph[i][j];
        }

        // k is the intermediatory vertex
        for(k=0; k<n;k++) {
            for(i =0; i<n; i++) {
                for(j=0; j<n; j++) {
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printSolution(dist,n);
    }

    void printSolution(int dist[][], int n)
    {
        System.out.println("Following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<n; ++i)
        {
            for (int j=0; j<n; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        FloydWarshallAPSP apsp = new FloydWarshallAPSP();

        // Print the solution
        apsp.allPairShortestPath(graph,4);
    }
}

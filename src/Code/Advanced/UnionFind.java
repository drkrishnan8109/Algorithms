package Code.Advanced;

/**
 * Created by drkrishnan on 01.04.2018.

 * Friends Circle (Number of clusters or number of connected components)
 *
 * Logic of union find
 * 1. Initialize parents of each node to point to itsef
 * 2. If two nodes are connected, union them
 *
 * Cycle detection : if find(u)==find(v)=> cycle detected else do union(x,y)
 * where x and y are parents of u and v
 *
 * Union by rank reduces height, otherwise height could be O(n)
 * Union by rank could be of height O(log n)
 * Using path compression, height can again reduce to less than O(log n)
 * and amortized height could be a constant
 *
 * Path compression means, when find() is used to find a parent of p by going up,
 * then parent[p] is updated with this result, hence the height of tree reduces
 * for further searches
 */
public class UnionFind {

        public int[] parent, rank;
        int count;

        public int find(int p) {
            while (parent[p] !=p) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootP] < rank[rootQ])
                parent[rootP] = rootQ;
            else if(rank[rootQ] < rank[rootP])
                parent[rootQ] = rootP;
            else{ // i.e when both ranks are equal, increase one of the ranks
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
        }

        public int count() {
            return count;
        }

        //find friends circle number
        public int findCircleNum(int[][] M) {
            int n = M.length;
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }


            /**The dependency here is transitive, hence we dont need to traverse
            all n*n nodes, bcs M[i][j] = M[j][i]. So traverse only the upper traingle of the matrix
            (or lower traingle- either of them,since the other one gives the exact direct connections here)
             **/
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    //if connected as direct friend, then do union
                    if (M[i][j] == 1) union(i, j);
                }
            }
            return count();
        }

        public boolean isCycle(int[][] M) {
            int n = M.length;
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
            // rank[i]=0; already 0 by default


            // update limits based on n*n matrix or not
            for(int i=0;i<n-1;i++) {
                for (int j = i+1; j < n; j++) {
                    if (i != j) {
                        int x = find(i);
                        int y = find(j);
                        if (x == y)
                            return true;
                        union(i, j);
                    }
                }
            }
            return false;
        }
    }
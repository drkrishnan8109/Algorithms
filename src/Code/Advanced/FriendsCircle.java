package Code.Advanced;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by drkrishnan on 05.05.2018.
 *
 * This problem finds the number of connected components
 * It can be solved by DFS or UnionFind or BFS
 * DFS gives a simple solution. xy  x
 */
public class FriendsCircle {

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }



    //BFS
    public int findCircleNumBFS(int[][] M) {
        int count = 0;
        for (int i=0; i<M.length; i++)
            if (M[i][i] == 1) {
                count++;
                BFS(i, M);
            }
        return count;
    }

    public void BFS(int student, int[][] M) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(student);
        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i=0;i<queueSize;i++) {
                int j = queue.poll();
                M[j][j] = 2; // marks as visited
                for (int k=0;k<M[0].length;k++)
                    if (M[j][k] == 1 && M[k][k] == 1) queue.add(k);
            }
        }
    }
}

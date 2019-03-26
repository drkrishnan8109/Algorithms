package Code.Matrix;

import Code.Practice.MatchStringsGoogleQstn;

/**
 * Created by drkrishnan on 05.05.2018.
 */
public class LongestIncPath {

    //Use DFS approach of matrix
    public int findLongestIncPath(int[][] M) {
        int n=M.length;
        int m=M[0].length;

        //Cache has to be updated to -1 to distinguish between
        // 1. not yet traversed(-1) and 2.no increasing path(0)
        int[][] cache = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                cache[i][j]=-1;
            }
        }

        int longest=0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                longest = Math.max(longest,dfs(M,i,j,cache));
            }
        }
    return longest;
    }

    public int dfs(int[][] M, int i, int j, int[][] cache) {
        if(cache[i][j]!=-1)
            return cache[i][j];

        int[] rowNr = new int[] {0,-1,0,1};
        int[] colNr = new int[] {-1,0,1,0};

        int x,y, currMax=0;
        for(int k=0;k<4;k++) {
            x=i+k;
            y=i+j;
            if(x>=0 && y>=0 && x<M.length && y<M[0].length
                    && M[i][j]<M[x][y]) {
                currMax = Math.max(currMax,
                        dfs(M,x,y,cache));
            }
        }
        cache[i][j] = currMax+1;
        return currMax+1;
    }
}

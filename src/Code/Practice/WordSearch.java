package Code.Practice;

/**
 * Created by developer on 1/14/18.
 * It is important to reset the visited back to false if we couldnt find,
 * bcs this cell need to serve other combinations
 */
public class WordSearch {
        public boolean exist(char[][] board, String word) {
            if(word==null || word.isEmpty() || board==null) return false;
            int row=board.length;
            int col=board[0].length;
            if(row==0 || col==0) return false;
            boolean[][] visited = new boolean[row][col];

            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    if(board[i][j]==word.charAt(0) && checkWordExist(board,word,0,i,j,visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean checkWordExist(char[][] board, String word, int curr, int i, int j, boolean[][] visited) {
            if(word.length()==curr) return true;
            int m= board.length;
            int n= board[0].length;
            if(i>=m || j>=n || i<0 ||j<0) return false;
            if(!visited[i][j] && board[i][j]==word.charAt(curr)) {
                visited[i][j]=true;
                if( checkWordExist(board,word,curr+1,i-1,j,visited) ||
                        checkWordExist(board,word,curr+1,i,j-1,visited) ||
                        checkWordExist(board,word,curr+1,i+1,j,visited) ||
                        checkWordExist(board,word,curr+1,i,j+1,visited))
                    return true;
                visited[i][j]=false; //Imp to set visited to false
            }
            return false;
        }
    }

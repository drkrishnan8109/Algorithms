package Code.Advanced;

import Code.Trees.Trie;
import Code.Trees.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**Refer correct implementation:
 * Refer: https://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 *
 * */
public class WordBoggleDFSTrie {
   /* Set<String> result = new HashSet<String>();

    public List<String> findWords(char[][] board, String[] words) {

        //Add words to trie.
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        List<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                dfs(board, visited, "", i, j, trie, result);
            }
        }
        return result;
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int i,int j, Trie trie,List<String> result ){
            if(i<0 || j<0 || i>=board.length || j>= board[0].length || visited[i][j])
                return;
            //BC
            str = str + board[i][j];
            if(!trie.startsWith(str))
                return;
            if(trie.search(str))
                result.add(str);

            visited[i][j]=true;
            dfs(board, visited, str, i-1, j, trie, result);
            dfs(board, visited, str, i+1, j, trie, result);
            dfs(board, visited, str, i, j-1, trie, result);
            dfs(board, visited, str, i, j+1, trie, result);
            visited[i][j]=false;
    }*/
}

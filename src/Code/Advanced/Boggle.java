package Code.Advanced;

import java.util.*;

/**
 * Created by drkrishnan on 29.03.2018.
 */
public class Boggle {
        TrieNode root= new TrieNode();

        class TrieNode {
            char c;
            HashMap<Character,TrieNode> children;
            boolean isEnd=false;

            public TrieNode() {
                this.children= new HashMap<Character,TrieNode>();
            }

            public TrieNode(char c) {
                this.c = c;
                this.children= new HashMap<Character,TrieNode>();
            }

            public void setEnd() {
                this.isEnd=true;
            }
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode curr= this.root;

            for(char c: word.toCharArray()) {
                if(curr.children.containsKey(c)) {
                    curr=curr.children.get(c);
                }
                else {
                    TrieNode newNode = new TrieNode(c);
                    curr.children.put(c, newNode);
                    curr=newNode;
                }
            }
            curr.setEnd();
        }



        public List<String> findWords(char[][] board, String[] words) {

            //Create Trie of dictionary words
            for(String s:words) {
                addWord(s);
            }

            TrieNode curr= this.root;
            char c;
            boolean[][] visited= new boolean[board.length][board[0].length];
            List<String> res = new LinkedList<>();

            StringBuilder sb= new StringBuilder();
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[0].length;j++) {
                    c = board[i][j];
                    if(curr.children.containsKey(c)) {
                        sb.append(c);
                        visited[i][j]=true;
                        matchWordRec(board,i,j,visited,curr.children.get(c),res,sb);
                        //Important to reset sb & visited to previous status
                        sb.deleteCharAt(sb.length() - 1);
                        visited[i][j]=false;
                    }
                }
            }
            return res;
        }


        public void matchWordRec(char[][] board, int i, int j, boolean[][] visited, TrieNode curr,
                                 List<String> res, StringBuilder sb) {
            //BC
            if(curr.isEnd) {
                res.add(sb.toString());
                return;
            }

            int[] rowNr = {0,0,-1,1};
            int[] colNr = {-1,1,0,0};

            int k=0;
            while(k<rowNr.length) {
                if(isSafe(board,i+rowNr[k],j+colNr[k]) && !visited[i+rowNr[k]][j+colNr[k]]
                        && curr.children.containsKey(board[i+rowNr[k]][j+colNr[k]])) {

                    visited[i + rowNr[k]][j + colNr[k]] = true;
                    sb.append(board[i + rowNr[k]][j + colNr[k]]);
                    matchWordRec(board, i + rowNr[k], j + colNr[k], visited,
                                curr.children.get(board[i + rowNr[k]][j + colNr[k]]), res, sb);
                    //Important to reset sb and visited to previous status
                    sb.deleteCharAt(sb.length() - 1);
                    visited[i + rowNr[k]][j + colNr[k]] = false;
                }
                k++;
            }
            return;
        }

        public boolean isSafe(char[][] board, int i, int j) {
            if(i>=0 && i<board.length && j>=0 && j<board[0].length)
                return true;
            else
                return false;
        }

        public static void main(String args[]) {
            Boggle ws = new Boggle();
            char[][] board = new char[][] {
                    {'o','a','a','n'},
                    {'e','t','a','e'},
                    {'i','h','k','p'},
                    {'i','f','l','v'}};

            String[] words = new String[] {"oath","pea","eat","rain"};

            for(String s:words) {
                ws.addWord(s);
            }

            List<String> ls = ws.findWords(board,words);

            Iterator itr = ls.listIterator();
            while (itr.hasNext()) {
                System.out.println(itr.next());
            }

            String s= "abcd";
            System.out.println(s.substring(0));
            System.out.println(s.substring(0,0));
            System.out.println(s.substring(0,1));
            System.out.println(s.substring(1));
            System.out.println(s.substring(3));
            System.out.println(s.substring(2,2));
            System.out.println(s.substring(2,3));
            System.out.println(s.substring(s.length()-1));
            System.out.println("".length());

        }
    }

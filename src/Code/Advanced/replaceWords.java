package Code.Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by drkrishnan on 30.03.2018.
 */
public class replaceWords {
        TrieNode root = new TrieNode();

        class TrieNode {
            char c;
            HashMap<Character,TrieNode> children;
            boolean isEnd;

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

        public String replaceWords(List<String> dict, String sentence) {

            for(String s: dict)
                addWord(s);

            StringBuilder buildSentence= new StringBuilder();
            for(String s: sentence.split(" ")) {
                String str = searchRootWord(s);
                if(str == null)
                    buildSentence.append(s+" ");
                else
                    buildSentence.append(str+" ");
            }
            return buildSentence.toString();
        }

        public String searchRootWord(String s) {
            TrieNode curr= root;
            StringBuilder sb = new StringBuilder();
            for(char c:s.toCharArray()) {
                if(curr.children.containsKey(c)) {
                    sb.append(c);
                    curr=curr.children.get(c);
                    if(curr.isEnd) {
                        return sb.toString();
                    }
                }
            }
            return null;
        }

        public static void main(String args[]) {
            String sentence = "the cattle was rattled by the battery";
            List<String> dict = Arrays.asList("cat","rat","bat");

            replaceWords rW = new replaceWords();
            String s= rW.replaceWords(dict,sentence);
            System.out.println(s);
        }
    }
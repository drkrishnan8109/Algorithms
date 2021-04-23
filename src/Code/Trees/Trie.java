package Code.Trees;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dhanya on 11/15/17.
 */
public class Trie {
        public TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        //while inserting, we need to create TrieNode within the loop,
        // bcs there are no existing nodes
        public void insert(String word) {
            HashMap<Character,TrieNode> children = root.children;

            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                TrieNode t;
                if(children.containsKey(c)) {
                    t = children.get(c);
                    //children = t.children;
                }
                else {
                    t = new TrieNode(c);
                    children.put(c, t);
                    //children = t.children;
                }
                children = t.children;

                //set leaf node; we cant do this outside loop bcs t is created inside loop,
                //hence not accessible within loop

                if(i==word.length()-1)
                    t.isLeaf = true;
            }
        }

        public boolean search(String word) {
            TrieNode t = searchNode(word);
            if (t != null && t.isLeaf) {
              return true;
            }
            return false;
        }

        //IMP: return TrieNode, then check if this node is leaf
        public TrieNode searchNode(String word) {
            HashMap<Character,TrieNode> children = root.children;
            TrieNode t = null;

            for(int i=0; i<word.length();i++) {
                char c = word.charAt(i);
                if(!children.containsKey(c)) {
                    return null;
                }
                else {
                    t = children.get(c);
                    children = t.children;
                }
            }
            return t;
        }

        public boolean findprefixSubString(String word) {
            TrieNode t = searchNode(word);
            if(t!= null)
                return true;
            return false;
        }


    @Test
    public void searchWord() {
        Trie myTrie = new Trie();

        myTrie.insert("HELL");
        myTrie.insert("HELLOGOOGLE");
        assertTrue(myTrie.search("HELL"));
        assertFalse(myTrie.search("GOOGLE"));

        myTrie.insert("OH!HELL");
        assertFalse(myTrie.search("OH!"));
        assertTrue(myTrie.findprefixSubString("OH!"));

        assertFalse(myTrie.search("GOOG"));
        assertFalse(myTrie.findprefixSubString("GOOG"));
    }
}

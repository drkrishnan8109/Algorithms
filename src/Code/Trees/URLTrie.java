package Code.Trees;

import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

/**
 * Created by Dhanya on 11/15/17.
 */
public class URLTrie{
URLTrieNode root;

    public URLTrie() {
        root = new URLTrieNode();
    }

    public void insert(String url) {
        String[] str = url.split("\\.");
        HashMap<String,URLTrieNode> children = root.children;

        for(int i=str.length-1; i>=0; i--) {
            URLTrieNode t;
            if(children.containsKey(str[i])) {
               t = children.get(str[i]);
            }
            else {
                System.out.println("inserted: " + str[i]);
                t = new URLTrieNode(str[i]);
                //imp step, i always forget
                children.put(str[i],t);
            }
            t.count += 1;
            children = t.children;
        }
    }

    public int findSubStringCount(String url) {
        String[] str = url.split("\\.");
        HashMap<String,URLTrieNode> children = root.children;
        URLTrieNode t = null;

        for(int i=str.length-1; i>=0; i--) {
            if(children.containsKey(str[i])) {
                t = children.get(str[i]);
                children = t.children;
            }
            else {
                return 0;
            }
        }
        return t.count;
    }

    @Test
    public void findCount() {
        URLTrie myTrie= new URLTrie();
        myTrie.insert("abc.google.com");
        myTrie.insert("abc.pqr.google.com");
        myTrie.insert("pqr.google.com");
        myTrie.insert("yahoo.com");

        assertEquals(4, myTrie.findSubStringCount("com"));
        assertEquals(3, myTrie.findSubStringCount("google.com"));
        assertEquals(2, myTrie.findSubStringCount("pqr.google.com"));

    }

}

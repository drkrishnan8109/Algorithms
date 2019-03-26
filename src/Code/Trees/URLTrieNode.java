package Code.Trees;

import java.util.HashMap;

/**
 * Created by Dhanya on 11/15/17.
 */
public class URLTrieNode {
    public int count=0;
    String s=null;
    HashMap<String,URLTrieNode> children;

    public URLTrieNode() {
        children = new HashMap<String,URLTrieNode>();
    }

    public URLTrieNode(String s) {
        this.s = s;
        children = new HashMap<String,URLTrieNode>();
    }
}

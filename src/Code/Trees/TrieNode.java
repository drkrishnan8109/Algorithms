package Code.Trees;

import java.util.HashMap;

/**
 * Created by Dhanya on 11/15/17.
 */
public class TrieNode {
    char c;
    HashMap<Character,TrieNode> children;
    public boolean isLeaf;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }

    public TrieNode(char c) {
        this.c = c;
        children = new HashMap<Character, TrieNode>();
    }
}

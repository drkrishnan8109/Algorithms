package Code.Trees;


import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dhanya on 11/15/17.
 */


//Can query prefix substrings & suffix substrings, but not middle substrings
public class SuffixTrie extends Trie {
    public SuffixTrie() {
        super();
    }

    //Arrays.copyOfRange takes linear time! :(
    public void insert(String word) {
        char[] arr = word.toCharArray();
        for(int i=0 ; i<word.length();i++) {
            super.insert(
                    String.copyValueOf(
                            Arrays.copyOfRange(arr,i,word.length())));
        }
    }

    public boolean findAnySubstring(String word) {
        return findprefixSubString(word);
    }

    @Test
    public void searchSubString() {
        SuffixTrie myTrie = new SuffixTrie();

        myTrie.insert("HELLOGOOGLE");
        assertTrue(myTrie.search("GOOGLE"));

        assertFalse(myTrie.search("GOO"));

        myTrie.insert("OH!HELL");
        assertTrue(myTrie.findAnySubstring("GOOG"));
    }
}

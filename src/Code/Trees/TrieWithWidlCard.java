package Code.Trees;

import java.util.*;

public class TrieWithWidlCard {
    public static class TrieNode {
        public boolean end = false;
        public final Map<Character, TrieNode> children = new HashMap<>();
    }

    public static class TrieFinder {

        private final char wildcard;

        TrieFinder(char wildcard) {
            this.wildcard = wildcard;
        }

        List<String> find(String prefix, String suffix, TrieNode trie) {
            List<String> results = new ArrayList<>();
            if (trie.end) {
                results.add(prefix);
                return results;
            }
            Character c = suffix.length() == 0 ? null : suffix.charAt(0);
            if (c == null || c == wildcard) {
                for(Map.Entry<Character, TrieNode> entry : trie.children.entrySet()) {
                    results.addAll(
                            find(prefix + entry.getKey(), c == null ? "" : suffix.substring(1), entry.getValue())
                    );
                }
            } else if (trie.children.get(c) != null) {
                results.addAll(find(prefix + c, suffix.substring(1), trie.children.get(c)));
            }

            return results;
        }
    }


    public static class TrieBuilder {
        public TrieNode createTrie(List<String> words) {
            TrieNode trie = new TrieNode();
            for (String word: words) {
                placeNodes(word, trie);
            }

            return trie;
        }

        private void placeNodes(String word, TrieNode node) {
            if (word.length() == 0) {
                node.end = true;
            } else {
                char c = word.charAt(0);
                TrieNode next = node.children.get(c);
                if (next == null) {
                    next = new TrieNode();
                    node.children.put(c, next);
                }
                placeNodes(word.substring(1), node.children.get(c));
            }
        }
    }




    public static void main(String[] args) {
        List<String> dict = Arrays.asList("all", "also", "always", "book", "bold", "bounce", "bouldering", "car", "cat", "cattle", "cafe", "caf");
        TrieBuilder builder = new TrieBuilder();
        TrieNode trie = builder.createTrie(dict);
        System.out.println(trie.children.size());
        TrieFinder finder = new TrieFinder('*');
        List<String> a = finder.find("", "a", trie);
        List<String> al = finder.find("", "al", trie);
        List<String> b = finder.find("", "b", trie);
        List<String> bo = finder.find("", "bo", trie);
        List<String> b_ = finder.find("", "b*", trie);
        List<String> bou_ = finder.find("", "bou*", trie);
        List<String> b__l = finder.find("", "b**l", trie);
        List<String> b___ = finder.find("", "b***", trie);
    }


}
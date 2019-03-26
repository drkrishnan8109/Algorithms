package Code.Advanced;

import java.util.*;

/**
 * Created by drkrishnan on 05.05.2018.
 *
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.

 Examples:

 Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 Output: Order of characters is 'b', 'd', 'a', 'c'
 Note that words are sorted and in the given language "baa"
 comes before "abcd", therefore 'b' is before 'a' in output.
 Similarly we can find other orders.

 Input:  words[] = {"caa", "aaa", "aab"}
 Output: Order of characters is 'c', 'a', 'b'


 Any kind of relative ordeing -> Use topological sort
 Here compare first two words, go through each letters and find first mismatch.
 It is the order within of characters. Similarly continue for each adjacent words
 and build a graph based on this order
 Now traverse the graph & do topological sorting
 */


//TODO

public class AlienLanguageOrderOfChars {

    public class GraphAlien {
        int size;
        LinkedList<Integer>[] adj;
        public GraphAlien(int size) {
            this.size=size;
            for(int i=0;i<size;i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
        }
    }

  /*  public List<Character> findOrder(String[] words) {
        if(words==null)
            return new LinkedList<>();

        int numChars = maxLength(words);
        GraphAlien graph = new GraphAlien(numChars);

        for (int i = 0; i < words.length - 1; i++)
        {
            // Take the current two words and find the first mismatching character
            String word1 = words[i];
            String word2 = words[i+1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
            {
                // If we find a mismatching character, then add an edge
                // from character of word1 to that of word2
                if (word1.charAt(j) != word2.charAt(j))
                {
                    graph.addEdge(word1.charAt(j), word2.charAt(j));
                    break;
                }
            }
        }

        boolean[] isCycle = new boolean[numChars];
        boolean[] visited = new boolean[numChars];

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<numChars;i++) {
            topologicalSort(i, numChars,graph,visited,isCycle,stack);
        }

        LinkedList<Integer> res;

        return res
    }*/

    public boolean topologicalSort(int i, int numChars, GraphAlien graph,
                                           boolean[] visited, boolean[] isCycle,
                                           Stack<Integer> stack) {
            if (!visited[i]) {
                visited[i]=true;
                isCycle[i]=true;
                Iterator<Integer> itr = graph.adj[i].iterator();
                while (itr.hasNext()) {
                    Integer j = itr.next();
                    if(isCycle[j])
                        //We have loop, hence return empty list
                        return true;
                    else if(!visited[j]){
                        if(topologicalSort(i,numChars,graph,visited,isCycle,stack))
                            return true;
                    }
                }
                stack.push(i);
            }
        isCycle[i]=false;
        return false;
    }

    public int maxLength(String[] words) {
        int max=0;
        for(String s:words) {
            max = Math.max(max, s.length());
        }
        return max;
    }
}

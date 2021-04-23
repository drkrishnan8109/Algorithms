package Code.Advanced;

import Code.Advanced.Graph.Graph;
import Code.Advanced.Graph.GraphBasedOnArray;
import Code.Advanced.Graph.GraphNode;

import javax.xml.stream.events.Characters;
import java.util.*;

/**
 * Created by drkrishnan on 05.05.2018.
 * <p>
 * Given a sorted dictionary (array of words) of an alien language, find order of characters in the language.
 * <p>
 * Examples:
 * <p>
 * Input:  words[] = {"baa", "abcd", "abca", "cab", "cad"}
 * Output: Order of characters is 'b', 'd', 'a', 'c'
 * Note that words are sorted and in the given language "baa"
 * comes before "abcd", therefore 'b' is before 'a' in output.
 * Similarly we can find other orders.
 * <p>
 * Input:  words[] = {"caa", "aaa", "aab"}
 * Output: Order of characters is 'c', 'a', 'b'
 * <p>
 * <p>
 * Any kind of relative ordeing -> Use topological sort
 * Here compare first two words, go through each letters and find first mismatch.
 * It is the order within of characters. Similarly continue for each adjacent words
 * and build a graph based on this order
 * Now traverse the graph & do topological sorting
 * b->a, d-> a, a->c, b->d
 */


//TODO

public class AlienLanguageOrderOfChars {

    public static void main(String args[]) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        AlienLanguageOrderOfChars obj = new AlienLanguageOrderOfChars();
        obj.findOrderLanguage(words);
    }

    public List<Characters> findOrderLanguage(String[] words) {
        List<Characters> orderList = new ArrayList<>();

        if (words.length <= 1)
            return orderList;
        int j = 0, l = 0;

        GraphBasedOnArray g = new GraphBasedOnArray(26, false);
        for (int i = 1; i < words.length; i++) {
            j = i - 1;
            int index = 0;
            for (index = 0; index < Math.min(words[i].length(), words[j].length()); index++) {
                if (words[i].charAt(index) == words[j].charAt(index))
                    continue;
                //add edge words[i].charAt(index) to words[j].charAt(index)
                g.addEdge( words[i].charAt(index) - 'a',words[j].charAt(index) - 'a');
                break;
            }
        }
        topologicalSort(g);
        //Add stack contents to list .....
        return orderList;
    }

    public void topologicalSort(GraphBasedOnArray g) {
       boolean[] visited = new boolean[g.getSize()];
        LinkedList<Character> stack = new LinkedList<Character>();
        //here iterate over all vertices -> based on size of graph -- that is a problem...
        // Problem: first we get all correct chars, and further chars will also be added by default
        for (int i = 0; i < g.getSize(); i++) {
            if (!visited[i]) {
                dfs(g, visited, stack, i);
            }
        }
        // Print contents of stack
        while (!stack.isEmpty())
        {
            System.out.print((char)('a' + stack.pop()) + " ");
        }
    }

    public void dfs(GraphBasedOnArray g, boolean[] visited, LinkedList<Character> stack, int i) {
        if(visited[i])
            return;
        visited[i]=true;
        LinkedList<Integer> neighbours= g.adjArray[i];
        //Here iterate only over neighbours, not all vertices or 26
        for(Integer k: neighbours) {
            dfs(g,visited,stack,k);
        }
        stack.push((char)(i+'a'));
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

    /*public boolean topologicalSort(int i, int numChars, GraphAlien graph,
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

  }*/

package Code.Practice;

import Code.DynamicProgramming.WordBreak;

import java.util.*;

/**
 * Created by drkrishnan on 05.05.2018.
 *
 * !!Not working, Fix
 *
 * Find shortest length of transformation -hence use BFS for shortest length
 * -Dont use recursion, bcs it ends in DFS
 * BFS approach
 *
 * If list of transformation needed, use treemap(destnword, sourceword)
 */
public class WordLadder {

        class WordNode {
            String word;
            int steps;
            public WordNode(String word,int steps) {
                this.word=word;
                this.steps=steps;
            }
        }

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            if(beginWord==null || endWord==null || beginWord.length()==0 || endWord.length()==0)
                return -1;
            if(beginWord==endWord)
                return 0;

            beginWord=beginWord.toLowerCase();
            endWord=endWord.toLowerCase();
            wordList.add(endWord);

            Queue<WordNode> queue= new LinkedList<>();
            queue.add(new WordNode(beginWord,0));

            Set<String> visited = new HashSet<>();

            while(!queue.isEmpty()) {
                WordNode currWNode= queue.poll();
                String currWord = currWNode.word;
                for(String oneEditWord: findOneEditWords(currWord)) {
                    if(wordList.contains(oneEditWord)) {
                        if(oneEditWord.equals(endWord))
                            return currWNode.steps;
                        else if(!visited.contains(oneEditWord)) {
                            queue.add(new WordNode(oneEditWord,currWNode.steps+1));
                            visited.add(oneEditWord);
                        }
                    }
                }
                currWNode.steps++;
            }
            return 0;
        }

        public List<String> findOneEditWords(String currWord) {
            char[] arr = currWord.toCharArray();
            List<String> result = new ArrayList<>();
            char temp;
            for(int i=0;i<arr.length;i++) {
                // temp is used to get the real character back after one edit
                temp=arr[i];
                for(char c='a';c<='z';c++) {
                    if(arr[i]!=c) {
                        arr[i]=c;
                    }
                    result.add(new String(arr));
                }
                arr[i]=temp;
            }
            return result;
        }
}

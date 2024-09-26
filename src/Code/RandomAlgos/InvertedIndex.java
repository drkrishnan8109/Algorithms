/*
 * Click `Run` to execute the snippet below!
 */

 import static org.junit.Assert.assertEquals;

 import java.io.*;
 import java.util.*;
 import java.util.ArrayList;
 import java.util.concurrent.ConcurrentHashMap;
 
 import javax.crypto.KeyAgreement;
 
 import org.apache.commons.lang3.tuple.*;
 
 /*
  * To execute Java, please define "static void main" on a class
  * named Solution.
  *
  * If you need more classes, simply define them inline.
  */
 
 class Solution {
 
   /**
   n documents
  2.  Reverse index
   - Map word , count
   - word - <doc1, count1>, <doc2, count2>
 3. Ranking
   - word max in which document
    */

 public static void createInvertedIndexperdoc(HashMap<String,ArrayList<ImmutablePair<Integer,Integer>>> index, Integer docId, String[] words) {
   HashMap<String,Integer> countMap = new HashMap<>();
     for(String word: words) {
       if(countMap.containsKey(word)) {
         countMap.put(word.toString(), countMap.get(word) + 1);
       }
       else {
         countMap.put(word, 1);
       }
     }
     System.out.println("countMap " + countMap.toString()); 
 
     String key; Integer value;
     for(HashMap.Entry<String, Integer> entry : countMap.entrySet()) {
         key= entry.getKey();
         value = entry.getValue();
         if(index.containsKey(key)) {
           index.get(key).add(ImmutablePair.of(docId,value));
         }
         else {
           System.out.println(" New key in index  " + key);
           ArrayList<ImmutablePair<Integer,Integer>> list = new ArrayList<>();
           list.add(ImmutablePair.of(docId,value));
           index.put(key, list);
         }
     }
 
     System.out.println("Index is " + index.toString()); 
 }

 public static void createInvertedIndex(HashMap<String,ArrayList<ImmutablePair<Integer,Integer>>> index, HashMap<String,Integer> countMap ) {
     //TO DO Later clean up
 }

 public static void main rankIndexBasedOnCount(HashMap<String,ArrayList<ImmutablePair<Integer,Integer>>> index) {

    for(HashMap.Entry<String,ArrayList<ImmutablePair<Integer,Integer>>> entry : index.entrySet()){

        String word = entry.getKey();
        ArrayList<ImmutablePair<Integer,Integer>> doclist =  entry.getValue();
        // Step 2: Create a priority queue for each word to store top 10 documents by count
        PriorityQueue<ImmutablePair<Integer,Integer>> pq = new PriorityQueue<>(
                Compator.compareInt(ImmutablePair::getRight));

        for(ImmutablePair<Integer,Integer> docIdAndCount : doclist) {
            pq.offer(docIdAndCount);

            if(pq.size>20)
                pq.poll;
        }
    }
     }
 
 public static void main(String args[]) {
   HashMap<String,ArrayList<ImmutablePair<Integer,Integer>>> index = new HashMap<>();
   createInvertedIndex(index, 123, new String[]{"abc", "abc", "cd", "cd", "cd"});
   createInvertedIndex(index, 324, new String[]{"abc", "def", "cd", "abc", "def"});
 
   assertEquals(2, index.get("abc").size());
   assertEquals(1, index.get("def").size());
   assertEquals(null, index.get("dfd"));
 }
 }
 
 
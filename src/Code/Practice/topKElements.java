/*
package Code.Practice;

import java.util.*;

*/
/**
 * Created by developer on 1/17/18.
 *//*

public class topKElements implements Comparator<Pair>{
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();

            int n= nums.length-1;
            int elmt=0;
            for(int i=0;i<n;i++) {
                elmt= nums[i];
                if(!hmap.containsKey(elmt)) {
                    hmap.put(elmt,1);
                }
                else {
                    hmap.put(elmt,hmap.get(elmt).intValue()+1);
                }
            }

            PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>(){
                @Override
                public int compare(Pair a, Pair b){
                    return a.count-b.count;
                }
            });

            for(Map.Entry<Integer,Integer> e : hmap.entrySet()) {
                Pair p=new Pair(e.getKey(),e.getValue());
                minHeap.offer(p);
                if(minHeap.size()>k){
                    minHeap.poll();
                }
            }

            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(minHeap.size()>0){
                arr.add(minHeap.poll().key);
            }
            return arr;
        }
    }
    class Pair{
        int key;
        int count;
        Pair(int k, int c){
            this.key=k; this.count=c;
        }

}
*/

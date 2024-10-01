
/*
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int temp;
        for(int i=0;i<nums.length;i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else {
                temp = map.get(nums[i]);
                map.put(nums[i],temp+1);
            }
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>
                (k,new Comparator<Map.Entry<Integer,Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer,Integer> e1, Map.Entry<Integer,Integer> e2) {
                        return e1.getValue()-e2.getValue();
                    }
                });

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}*/

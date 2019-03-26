package Code.Advanced;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by drkrishnan on 06.05.2018.
 *
 * DFS and Backtracking
 *  Whenever we use DFS and backtracking, for eg a recursive call within a forloop,
 * then after recursive call, remove last element in the sublist -> this maintains backtrack
 *
 */
public class PalindromePartitioning {

    //aaabac -> start,len -> substring(start,i) then recurse for remaining
    public List<List<String>> allPartition(String s) {
        List<String> partition = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        return allPartitionRec(s,0,partition,res);
    }

    public List<List<String>> allPartitionRec(String s, int start,
                                              List<String> partition,List<List<String>> res) {
        //Base Case
        if(start==s.length()) {
            res.add(partition);
        }
        for(int i=start+1;i<s.length()-1;i++) {
            String substr = s.substring(start,i);
            if(isPalindrome(substr)) {
                partition.add(substr);
                allPartitionRec(s,i,partition,res);
                partition.remove(partition.size()-1);
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        //TODO
        return true;
    }

    public int minCutPartition() {
    return 0;
    }
}

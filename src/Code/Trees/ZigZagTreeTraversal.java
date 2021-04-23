package Code.Trees;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTreeTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if(root==null) return resultList;
        zigzagLevelOrder(root,0,resultList);
        return resultList;
    }
    public void zigzagLevelOrder(Node root, Integer level, List<List<Integer>> resultList){
        if(root==null)
            return;
        if(resultList.size()<=level){
            resultList.add(new ArrayList<Integer>());
        }
        if(level%2==0) {
            resultList.get(level).add(root.data);
        }
        else{
            resultList.get(level).add(0,root.data);
        }
        zigzagLevelOrder(root.left,level+1,resultList);
        zigzagLevelOrder(root.right,level+1,resultList);
    }
}

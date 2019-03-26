package Code.Trees;

import Code.Practice.MatchStringsGoogleQstn;
import Code.Practice.MergeIntervals;

/**
 * Created by drkrishnan on 05.05.2018.
 */
public class BTMaxPathSUM {

    /**
     * 4 Cases to consider at any node to find max sum including this node
     * 1. Processing begins from leaf - hence recursively call until root==null, return0
     * 2. Max can be node alone or node+leftsum or node+rightsum or node+leftsum+rightsum
     *      This max gives the current maximum sum seen so far
     * 3. To update maxSum, we need to pass the sum value seen so far to the parent node.
     *      Here be careful that we can pass either node+leftsum or node+rightsum only.
     *      Dont pass node+leftsum+rightsum because it results in invalid path.
     * 4. Use a result class to share maximum sum across function calls.
     * **/

    public int maxPathSum(Node root) {
        Result max= new Result();
        findMaxPathsumBetweenTwoLeaves(root,max);
        return max.max;
    }

    //Use a result class to share maximum sum across function calls
    public class Result {
        int max= Integer.MIN_VALUE;
    }

    public int findMaxPathsumBetweenTwoLeaves(Node root, Result maxSum) {
        if(root==null)
            return 0;

        int l= findMaxPathsumBetweenTwoLeaves(root.left,maxSum);
        int r= findMaxPathsumBetweenTwoLeaves(root.right,maxSum);

        int maxAll = Math.max(root.data, root.data+l+r);
        maxSum.max = Math.max(maxSum.max,maxAll);

        int maxWithSinglechildPath = findMax(root.data, root.data+l, root.data+r);
        return  maxWithSinglechildPath;

    }

    public int findMax(int a, int b, int c) {
        return Math.max(a,Math.max(b,c));
    }

    public int findMaxLeafToRoot(Node root, Result maxSum) {
        if(root==null)
            return 0;
        int l=findMaxLeafToRoot(root.left,maxSum);
        int r=findMaxLeafToRoot(root.right,maxSum);

        int maxWithSinglechild = Math.max(root.data+l, root.data+r);
        maxSum.max = Math.max(maxSum.max,maxWithSinglechild);
        return maxWithSinglechild;
    }
}

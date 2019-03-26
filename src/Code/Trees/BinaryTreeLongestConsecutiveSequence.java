package Code.Trees;

/**
 * Created by drkrishnan on 01.05.2018.
 */
public class BinaryTreeLongestConsecutiveSequence {
    /*
        int max=0;

        public int longestConsecutive(TreeNode root) {
            helper(root);
            return max;
        }

        public int helper(TreeNode root) {
            if(root==null)
                return 0;

            int l = helper(root.left);
            int r = helper(root.right);

            int fromLeft = 0;
            int fromRight= 0;

            if(root.left==null){
                fromLeft=1;
            }else if(root.left.val-1==root.val){
                fromLeft = l+1;
            }else{
                fromLeft=1;
            }

            if(root.right==null){
                fromRight=1;
            }else if(root.right.val-1==root.val){
                fromRight = r+1;
            }else{
                fromRight=1;
            }

            max = Math.max(max, fromLeft);
            max = Math.max(max, fromRight);

            return max;
        }

    }
    */
}

package Code.Trees;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class kthSmalletsInBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public int kthSmallestIterative(Node root, int k) {
            LinkedList<Node> stack = new LinkedList<Node>();
            Node curr=root;
            while(!stack.isEmpty() || curr!=null) {
                if(curr!=null) {
                    stack.add(curr);
                    curr=curr.left;
                }
                else {
                    curr = stack.removeLast();
                    k--;
                    if(k==0) {
                        return curr.data;
                    }
                    curr=curr.right;
                }
            }
            return -1;
        }
    }

        public int kthSmallestRecursive(Node root, int k) {
            if(root==null || k<0)
                return -1;
            LinkedList<Integer> list = new LinkedList<>();
            if(inorderRec(root, k, list))
                return list.get(k-1);
            return -1;

        }

        //Works verified in leetcode 38.4 MB
        public boolean inorderRec(Node root, int k, LinkedList<Integer> list) {
            if(root==null)
                return false;

            if(inorderRec(root.left,k,list))
                return true;
            list.add(root.data);
            if(list.size()==k)
                return true;
            if(inorderRec(root.right,k,list))
                return true;

            return false;

        }


    @Test
    public void test() {
        kthSmalletsInBST obj = new kthSmalletsInBST();
        int[] pre = new int[] {5,3,2,1,4,6};
        int[] in = new int[] {1,2,3,4,6,7,8};
        ConstructBinaryTree bst = new ConstructBinaryTree();
        Node n = bst.buildTree(pre,in);
        //Assert.assertEquals(kthSmallest(n, 5),6);
    }
}

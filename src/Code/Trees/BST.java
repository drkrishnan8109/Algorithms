package Code.Trees;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import sun.security.util.Cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by developer on 10/2/17.
 */
public class BST {
    public Node root;

    public boolean createBST(int[] A, int n){
        if(A==null) return false;

        for(int i=0;i<n;i++){
            insBST(new Node(A[i]));
        }
        return true;
        }

    public void insBST(Node item){
        if(this.root==null)
            this.root = item;
        else
            insBST(this.root, item);
    }

    public void insBST(Node root, Node elmt){
            if(elmt.data < root.data) {
                if(root.left == null)
                    root.left = elmt;
                else insBST(root.left,elmt);
            }
            else if(elmt.data > root.data){
                if(root.right == null)
                    root.right =elmt;
                else insBST(root.right,elmt);
            }
            else
                root = elmt;
    }

    public String toString(){
        return toString(this.root);
    }

    public String toString(Node root){
        if(root!=null)
        return "[" + toString(root.left) + root.data + toString(root.right) + "]";
        return "";
    }

    /**
     * Height of two subtrees never differ by more than one
     * O(N) time & O(H) Space where N is number of nodes and H is height
     * */
    public boolean isBalanced(Node root){
        if(checkHeight(root) == -1)
            return false;
        else
            return true;
    }

    public int checkHeight(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int hgtLeft, hgtRight;
        if (root.left != null) {
            hgtLeft = checkHeight(root.left) + 1;
           } else hgtLeft = 0;
        if (root.right != null) {
            hgtRight = checkHeight(root.right) + 1;
           } else hgtRight = 0;
        if ((Math.abs(hgtLeft - hgtRight)) > 1) return -1;
        else
            return Math.max(hgtLeft,hgtRight);
    }

    public boolean createMinBST(int[] sortedArr){
        if(createMinBST(sortedArr,0,sortedArr.length-1) != null)
           return true;
        else
            return false;
    }

    public Node createMinBST(int[] sortedArr, int left, int right){
        if(right<left) return null;
        int mid = (left + right)/2;
        Node n = new Node(sortedArr[mid]);
        n.left = createMinBST(sortedArr,0,mid-1);
        n.right = createMinBST(sortedArr,mid+1,right);
        return n;
    }

    //Assumption : first and second are definitely present in the tree
    // and first and second are different
    public Node findCommonAncestorBST(Node root, Node first, Node second){
        if(root==null || first == null || second==null)
            return null;
        //Recurse
        if(first.data<root.data && second.data<root.data) {
            //search left sub tree only
            if(root.left !=null)
                return findCommonAncestorBST(root.left, first,second);
        }
        else if(first.data>root.data && second.data>root.data){
            //search right subtree only
            if(root.right !=null)
                return findCommonAncestorBST(root.right, first,second);
        }
        return root;
    }


    //create path from root to each destination node
//traverse the paths from root, when there is mismatch, the previous node was lowest common ancestor
    public Node lca(Node root, Node a, Node b, List<Node> path1, List<Node> path2) {
        if(!findPath(root,a,path1) || !findPath(root,b,path2))
            return new Node(-1);

        for(int i=0;i<path1.size() && i<path2.size();i++) {
            if(!path1.get(i).equals(path2.get(i)))
                return path1.get(i-1);
        }
           return new Node(-1);
    }

    /***
     * Use backtrcking - since root is first added to path and finally removed
     * => this makes sure to remove a node if there is no valid path
     * **/
    boolean findPath(Node root, Node a, List<Node> path) {
        if(root==null)
            return false;
        path.add(root);
        if(root==a) {
            return true;
        }
        if(root.left!=null && findPath(root.left,a,path))
            return true;
        if(root.right!=null && findPath(root.right,a,path))
            return true;

        path.remove(path.size()-1);
        return false;
    }
    /**
     * O(n)
     * **/
    public Node findCommonAncestorAnyBT(Node root, Node first, Node second){
        if(root==null) return null;
        boolean on_left =false, on_right=false;

        on_left = isChild(root.left,first) || isChild(root.left, second);
        on_right = isChild(root.right,first) || isChild(root.right, second);

        if(on_left && on_right) return  root;
        Node childNode;
        if(on_left)
            childNode = root.left;
        else if(on_right)
            childNode = root.right;
        else return null;
        return findCommonAncestorAnyBT(childNode,first,second);
    }

    public boolean isChild(Node root, Node x){
        if(root==null || x ==null) return false;
        if(root.data==x.data) {
            return true;
        }
        return isChild(root.left,x) || isChild(root.right,x);
    }

    public ArrayList<Integer> inorder(Node root){
        if(root==null) return null;
        ArrayList<Integer> orderedList = new ArrayList<>();
        return inorder(root, orderedList);
    }

    public ArrayList<Integer> inorder(Node n, ArrayList<Integer> list) {
        if(n.left!=null)
            inorder(n.left,list);
        list.add(n.data);
        if(n.right!=null)
            inorder(n.right,list);
        return list;
    }

    public ArrayList<Integer> preorder(Node root){
        if(root==null) return null;
        ArrayList<Integer> orderedList = new ArrayList<>();
        return preorder(root, orderedList);
    }

    public ArrayList<Integer> preorder(Node n, ArrayList<Integer> list) {
        list.add(n.data);
        System.out.print(n.data);
        if(n.left!=null) preorder(n.left,list);
        if(n.right!=null) preorder(n.right,list);
        return list;
    }

    /***   unbalanced tree :
     *           o
     *          o o
     *         o
     *        o o
     *       o
     *
     *
     */

    @Test
    public void isBalancedTest1(){
        int[] A = new int[] {5,2,18,25};
        BST bst = new BST();
        bst.createBST(A,A.length);
        assertEquals(true,bst.isBalanced(bst.root));
    }

    @Test
    public void isBalancedTest2(){
        int[] A = new int[] {5,18,40,16,95};
        BST bst = new BST();
        bst.createBST(A,A.length);
        assertEquals(false,bst.isBalanced(bst.root));
    }

    @Test
    public void randArr(){
        int[] A = new int[] {5,18,40,16,95};
        BST bst = new BST();
        bst.createBST(A,A.length);
        String result = bst.toString();
        assertEquals("[5[[16]18[40[95]]]]",result);
    }

    @Test
    public void asc(){
        int[] A = new int[] {3,4,5,7};
        BST bst = new BST();
        bst.createBST(A,A.length);
        String result = bst.toString();
        assertEquals("[3[4[5[7]]]]",result);
    };

    @Test
    public void des(){
        int[] A = new int[] {60,20,16,15};
        BST bst = new BST();
        bst.createBST(A,A.length);
        String result = bst.toString();
        assertEquals("[[[[15]16]20]60]",result);
    };

    @Test
    public void isMinBST(){
        int[] sortedA = new int[] {2,5,6,8,9,11};
        BST bst = new BST();
        Node x = bst.createMinBST(sortedA,0,sortedA.length-1);
        bst.root = x;
        bst.preorder(bst.root);
        // assertEquals("[[2[5]]6[[8]9[11]]]",bst.toString());
    }

    @Test
    public void findCommonAnc(){
        int[] A = new int[] {5,18,40,16,95};
        BST bst = new BST();
        bst.createBST(A,A.length);
        Node x = bst.findCommonAncestorBST(bst.root, new Node(95), new Node(16));
        assertEquals(18,x.data);
    }

    @Test
    public void findCommonAncAnyBT(){
        int[] A = new int[] {5,18,40,16,95};
        BST bst = new BST();
        bst.createBST(A,A.length);
        Node x = bst.findCommonAncestorAnyBT(bst.root, new Node(95), new Node(16));
        assertEquals(18,x.data);
    }

    @Test
    public void inorderTest(){
        int[] A = new int[] {5,18,40,16,95};
        BST bst = new BST();
        bst.createBST(A,A.length);
        System.out.print(bst.toString());
        ArrayList<Integer> inorderList = bst.inorder(bst.root);
        assertEquals(5, inorderList.size());
               for(int i=1; i<inorderList.size(); i++){
            assertTrue(inorderList.get(i-1)<inorderList.get(i));
        }
    }

}

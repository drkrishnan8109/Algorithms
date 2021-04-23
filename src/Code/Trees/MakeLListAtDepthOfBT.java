package Code.Trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

/**
 * Created by developer on 10/21/17.
 */

//Assume all nodes have state unvisited
    // Use DFS
public class MakeLListAtDepthOfBT {

       public ArrayList<LinkedList<Node>> createLL(Node root) {
            if(root == null) return null;
            ArrayList<LinkedList<Node>> arrList = new ArrayList<LinkedList<Node>>();
            createLLAtDepth(root, 0, arrList);
            return arrList;
        }

    public void createLLAtDepth(Node root, int level, ArrayList<LinkedList<Node>> arrLst) {
        if(root == null) return;

        //The level is not visited before
        if( arrLst.size() == level) {
            LinkedList<Node> ll = new LinkedList();
            ll.add(root);
            arrLst.add(ll);
        }
        else {
            arrLst.get(level).add(root);
        }
        if(root.left!=null)
            createLLAtDepth(root.left,level +1, arrLst);
        if(root.right !=null)
            createLLAtDepth(root.right,level+1, arrLst);
    }

    @Test
    public void TestLLAtDepth(){
        int[] A = new int[] {5,18,40,16,95};
        BST bst = new BST();
        bst.createBST(A,A.length);
        ArrayList<LinkedList<Node>> arrList = createLL(bst.root);

        for(int i = 0; i<arrList.size();i++){
            LinkedList<Node> ll = arrList.get(i);
            for(Node n: ll){
                System.out.println("Arraylist at index:" + i);
                System.out.print(n.getData()+ " ");
            }
            System.out.println("");
        }
    }
    }

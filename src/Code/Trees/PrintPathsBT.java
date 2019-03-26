package Code.Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 1/21/18.
 */
public class PrintPathsBT {

    public void printPaths(Node root){
        ArrayList<Node> path = new ArrayList<Node>();
        printPathsRec(root,path);
    }

    /**
     *  1
     * 2 3
     *5   4 5
     * 7     6
     *
     *
     */
    
    public void printPathsRec(Node node,ArrayList<Node> path) {
       //BC
        if(node!=null) path.add(node);
        if(node==null) return;
        if(node.left==null && node.right==null)
            print(path);
        else{
            printPathsRec(node.left,path);
            printPathsRec(node.right,path);
        }
    }
    public void print(ArrayList<Node> path) {
        for(Node n:path){
            System.out.println(n.getData());
        }
    }

}

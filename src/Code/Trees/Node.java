package Code.Trees;

import java.util.Comparator;

/**
 * Created by developer on 10/2/17.
 */
public class Node {

    int data;
    public Node left;
    public Node right;

    Node(int item){
        this.data= item;
    }

    Node(int left, int item, int right){
        this.left = new Node(left);
        this.data = item;
        this.right = new Node(right);
    }

    public int getData(){
        return this.data;
    }

    //Comparator is static and overrides compare method
    public static Comparator<Node> valueComparator = new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.data - o2.data;
        }
    };

}

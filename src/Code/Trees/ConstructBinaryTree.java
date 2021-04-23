package Code.Trees;

import java.util.HashMap;

public class ConstructBinaryTree {
    class Index {
        int index;
    }
    public Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        Index preIndex = new Index();
        preIndex.index=0;
        return buildTree(preorder, inorder, 0, inorder.length-1,map,preIndex);
    }

    public Node buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map, Index preIndex) {
        if(inStart>inEnd)
            return null;
        Node tnode = new Node(preorder[preIndex.index]);
        preIndex.index++;
        //if(inStart==inEnd)
        // return tnode;
        int inIndex = map.get(tnode.data);
        tnode.left = buildTree(preorder,inorder,inStart,inIndex-1,map,preIndex);
        tnode.right = buildTree(preorder,inorder,inIndex+1,inEnd,map,preIndex);
        return tnode;
    }
}

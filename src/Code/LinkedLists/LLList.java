package Code.LinkedLists;

/**
 * Created by developer on 11/16/17.
 */
public class LLList {

    public LLNode partition (LLNode node, int x) {
        if(node == null) return null;

        LLNode beforeStart = null;
        LLNode afterStart = null;

        // In LL problems or any pointer problems, create new temp pointer
        // inside the loop, else wrong reference happens since its only ptrs, not variables !!
        while(node != null) {
            LLNode next = node.next;
            if(node.data<x) {
                //Insert in front of smaller list
                node.next = beforeStart;
                beforeStart = node;
            }
            else {
                //Insert in front of larger list
                node.next =afterStart;
                afterStart = node;
            }
            node = next;
        }

        //merge two lists
        if(beforeStart==null)
            return afterStart;
            //find end of beforestart and merge two list
        LLNode head = beforeStart;
        while(beforeStart.next !=null) {
            beforeStart = beforeStart.next;
        }
        beforeStart.next=afterStart;
        return head;
    }
}

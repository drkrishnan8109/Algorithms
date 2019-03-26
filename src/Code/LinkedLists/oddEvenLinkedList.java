package Code.LinkedLists;

/**
 * Created by developer on 1/13/18.
 * Put all odd nodes together, then all even nodes
 * 1 2 3 4 5 6
 * p1p2
 *
 */
public class oddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return head;

        ListNode result = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode connectNode = head.next;

        while(p1 != null && p2 != null){
            ListNode t = p2.next;
            if(t == null)
                break;

            p1.next = p2.next;
            p1 = p1.next;

            p2.next = p1.next;
            p2 = p2.next;
        }

        p1.next = connectNode;

        return result;
    }
}

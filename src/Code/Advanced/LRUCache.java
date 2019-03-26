package Code.Advanced;

import java.util.HashMap;

/**
 * Created by drkrishnan on 10.04.2018.
 */
public class LRUCache {

    Node head,end;
    HashMap<Integer,Node> memCache;
    int size=0;

    public class Node {
        int val;
        Node prev,next;

        public Node(int val,Node prev,Node next) {
            this.val=val;
            this.prev=prev;
            this.next=next;
        }
    }

    public LRUCache(int size) {
        memCache= new HashMap<>();
        size=this.size;
    }

    public int get(int key) {
        if (memCache.containsKey(key)) {
            //reorder
            Node n = memCache.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        if(memCache.containsKey(key)) {
           //Reorder
            Node existing = memCache.get(key);
            existing.val=val;
            remove(existing);
            setHead(existing);
        }
        else {
            //If cache is full, do eviction
            Node created = new Node(val,null,null);
            if(memCache.size()==size){
                memCache.remove(key);
                remove(end);
                setHead(created);
            }
            //else set as head
            else {
                setHead(created);
            }
            memCache.put(key,created);
        }

    }

    public void remove(Node n) {
        if(n.prev!=null)
            n.prev.next=n.next;
        else
            head=n.next;

        if(n.next!=null)
            n.next.prev=n.prev;
        else
            end=n.prev;
    }

    public void setHead(Node n) {
            n.next=head;
            n.prev=null;
            if(head!=null)
                head.prev=n;
            head=n;
            if(end==null)
                end = head;
    }

}

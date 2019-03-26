package Code.Practice;

import java.util.LinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;

/**
 * Created by Dhanya on 10/9/17.
 */
public class HTwithCollissions<K,V> {
    /**
     * If 2 keys hash to same location, use linked list to store both of them.
     * To retrieve appropriate KV pair, we need to compare with keys as well since collided
     * locations might have values from different keys. Hence storing both K and V are needed.
     * */

    public LinkedList<Cell<K,V>>[] bucket;
    private final int MAX_SIZE = 10;

    public HTwithCollissions(){
        bucket = new LinkedList[MAX_SIZE-1];
    }

    public int hashOfKey(K key){
        return key.hashCode()% bucket.length; // check!!
    }

    /**
     * returns true if the key is stored successfully
     * returns false if the key is already present
     * */
    public boolean put(K k, V v){
        int hash = hashOfKey(k);
       if(bucket[hash] == null){
           LinkedList<Cell<K,V>> linklst = new LinkedList<>();
           linklst.add(new Cell(k,v));
           bucket[hash] = linklst;
       }else{
           // Don't directly put here, bcs this key might be already present in HT
           LinkedList<Cell<K,V>> lst = bucket[hash];
           Iterator<Cell<K,V>> itr = lst.iterator();
           while(itr.hasNext()) {
               Cell curr = itr.next();
               if (curr.getKey().equals(k))
                   return false;
           }
           bucket[hash].add(new Cell(k, v));
       }
        return true;
    }

    public V get(K key){
        int hash = hashOfKey(key);
        if(bucket[hash] == null){
            return null;
        }else{
            LinkedList<Cell<K,V>> lst = bucket[hash];
            Iterator<Cell<K,V>> itr = lst.iterator();
            while(itr.hasNext()){
                Cell<K,V> curr = itr.next();
                if(curr.getKey().equals(key))
                    return curr.getValue(key);
            }
            return null;
        }
    }

    @Test
    public void newKeyValue(){
        HTwithCollissions<String, String> ht = new HTwithCollissions();
        String k1 = "key1", v1="value1";
        ht.put(k1,v1);
        assertEquals(v1,ht.get(k1));
    }

    @Test
    public void putSameKey(){
        HTwithCollissions<String, String> ht = new HTwithCollissions();
        String k2 = "key2", v2="value2";
        ht.put(k2,v2);
        assertEquals(false,ht.put(k2,v2));
    }

    @Test
    public void noKeyValueExists(){
        HTwithCollissions<String, String> ht = new HTwithCollissions();
        String k3="key3";
        assertEquals(null,ht.get(k3));
    }

    @Test
    public void largerThanBucket(){
        HTwithCollissions<Integer, String> ht = new HTwithCollissions();
        for(int i=0; i<20; i++){
            Integer key = new Integer(i);
            ht.put(key,new String("val"+i));
            Object v = ht.get(key);
            if(v!=null) {
                System.out.println("key: " + i + ",value: "
                        + v.toString() + ",hashCode:" + key.hashCode()%10);
            }
        }

    }
}

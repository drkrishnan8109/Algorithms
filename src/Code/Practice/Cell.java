package Code.Practice;

import java.util.Objects;

/**
 * Created by Dhanya on 10/9/17.
 */
public class Cell<K,V>{
    private K Key;
    private V Value;

    Cell(K k, V v){
        this.Key=k;
        this.Value=v;
    }

    public V getValue(K key){
        return this.Value;
    }

    public K getKey(){
        return this.Key;
    }

   }

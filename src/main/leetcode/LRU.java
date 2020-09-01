import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRU {
    private int contain;
    private LinkedHashMap<Integer,Integer> map;

    public LRU(int x){
        this.contain = x;
        this.map = new LinkedHashMap<Integer, Integer>();
    }

    public void set(int key,int value) {
        if (map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
        } else {
            if (contain > 0) {
                map.put(key,value);
            } else {
                removeValue();
                map.put(key,value);
            }
        }

    }

    public void removeValue(){
        Iterator<Integer> it = this.map.keySet().iterator();
        int temp = 1;
        while(it.hasNext()){
            temp = it.next();
        }
        map.remove(temp);
    }

}

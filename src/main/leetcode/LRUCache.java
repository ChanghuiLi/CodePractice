import java.util.Iterator;
import java.util.LinkedHashMap;

public class LRUCache {
    private LinkedHashMap<Integer,Integer> map;
    private int remain;
    public LRUCache(int capcaity){
        this.map = new LinkedHashMap<Integer, Integer>(capcaity);
        this.remain = capcaity;
    }
    private void put(int key,int value){
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key,value);
        } else {
            if(this.remain > 0) {
                map.put(key,value);
                this.remain --;
            } else {
                removeOld();
            }
        }

    }

    private int get(int key){
        if (map.containsKey(key)) {
            int temp = map.remove(key);
            map.put(key,temp);
            return temp;
        } else {
            return -1;
        }
    }


    private void removeOld() {
        Iterator<Integer> it = this.map.keySet().iterator();
        int oldKey = 1;
        if(it.hasNext()){
            oldKey = it.next();
        }
        map.remove(oldKey);
    }


}

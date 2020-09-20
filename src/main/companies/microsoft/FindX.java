package microsoft;

import java.util.HashMap;

public class FindX {
    public int findX(int[] arr) {
        // write your code here
        if (arr == null || arr.length <= 0) return 0;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length ; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                int temp = map.get(arr[i]);
                map.put(arr[i],++temp);
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key) == key) {
                res++;
            }
        }
        return res;
    }
}

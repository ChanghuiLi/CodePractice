import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        int[] res = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int temp = map.get(nums[i]);
                map.put(nums[i],temp++);
            } else {
                map.put(nums[i],1);
            }
        }

        for(int key : map.keySet()){

        }
        return res;
    }
}

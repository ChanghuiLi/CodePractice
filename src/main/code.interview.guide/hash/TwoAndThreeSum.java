package hash;

import java.util.*;

public class TwoAndThreeSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums==null||nums.length==0) return new int[2];
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            } else if (!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length-1; i++){
            HashSet<Integer> set = new HashSet<Integer>();
            for(int j = i + 1; j < nums.length; j++){
                int tempSum = nums[i] + nums[j];
                if (set.contains(nums[j])) {
                    List<Integer> tempres = new ArrayList<Integer>();
                    tempres.add(nums[i]);
                    tempres.add(nums[j]);
                    tempres.add(tempSum);
                    res.add(tempres);
                } else {
                    set.add(-tempSum);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-1; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int start = i+1;
            int end = nums.length-1;
            while (start < end) {
                int temp = nums[start] + nums[end] + nums[i];
                if(temp==0) {
                    List<Integer> tempres = new ArrayList<Integer>();
                    tempres.add(nums[i]);
                    tempres.add(nums[start]);
                    tempres.add(nums[end]);
                    res.add(tempres);
                    while(start < end && nums[start] == nums[start-1]) start++;
                    while(start < end && end !=nums.length&&nums[end] == nums[end+1]) end--;
                    start++;
                    end--;
                } else if (temp > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return res;
    }

}

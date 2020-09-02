package backtracking;

import java.util.ArrayList;
import java.util.List;

public class AReviewSubSet {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int Size = res.size();
            for (int j = 0; j < Size; j++) {
                List<Integer> temp = new ArrayList<Integer>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }

        }
        return res;
    }
//    public static List<List<Integer>> res2 = new ArrayList<List<Integer>>();
//    public static List<List<Integer>> subsets2(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return new ArrayList<List<Integer>>();;
//        }
//        List<Integer> temp = new ArrayList<Integer>();
//        process2(temp,nums,0);
//        return res2;
//    }
//
//    private static void process2(List<Integer> list, int[] nums, int start) {
//        res2.add(list);
//        for (int i = start; i < nums.length; i++) {
//            list.add(i);
//            process2(list,nums,i+1);
//        }
//}
}

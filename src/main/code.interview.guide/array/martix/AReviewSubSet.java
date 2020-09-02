package array.martix;

import java.util.ArrayList;
import java.util.List;

public class AReviewSubSet {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int Size = res.size();
                for (int j = 0; j < Size;j++) {
                    List<Integer> temp = new ArrayList<Integer>(res.get(j));
                    temp.add(nums[i]);
                    res.add(temp);
                }

        }
        return res;
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<Integer>(res.get(j));
                tmp.add(nums[i]);
                res.add(tmp);
            }
        }
        return res;
    }

    public static List<List<Integer>> helper(int[] nums,int start,int end,List<List<Integer>> res) {
        if (start == end) {
            List<Integer> tempres = new ArrayList<Integer>();
            tempres.add(nums[start]);
            res.add(tempres);
            return res;
        } else {
            for (int i = 0; i < nums.length; i++) {
            }
            List<Integer> tempend = new ArrayList<Integer>();
            tempend.add(nums[end]);
            res.add(tempend);
        }

        return res;
    }
}

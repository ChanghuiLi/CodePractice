package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AReviewALlSort {
    public static void main(String[] args) {
        int[] nums = {3,3,3,0};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        process2(nums,res,list,visited);
        return res;
    }

    private void process(int[] nums, List<List<Integer>> res, List<Integer> list, int[] visited) {
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) continue;
            visited[i] = 1;
            list.add(nums[i]);
            process(nums,res,list,visited);
            visited[i] = 0;
            list.remove(list.size()-1);

        }
    }
    private static void process2(int[] nums, List<List<Integer>> res, List<Integer> list, int[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] != 1){
                if ( i > 0 && nums[i-1] == nums[i] && visited[i-1] == 1) continue;
                visited[i] = 1;
                list.add(nums[i]);
                process2(nums,res,list,visited);
                visited[i] = 0;
                list.remove(list.size()-1);
            }
        }
    }
}

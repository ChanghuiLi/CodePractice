package backtracking;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.List;
// lt 39 ： https://leetcode-cn.com/problems/subsets/solution/xiang-xi-jie-shao-di-gui-hui-su-de-tao-lu-by-reedf/
public class AReviewCombineSum {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        int start = 0;
        int end = candidates.length-1;
        process(start,end,candidates,target,list);
        return res;
    }

    private void process(int start,int end,int[] candidates, int target, List<Integer> list) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i <= end; i++) {
                list.add(candidates[i]);
                process(start,end,candidates,target - candidates[i],list);
                list.remove(list.size()-1);
            }
        }
    }

    // dp方法
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        return res;
    }

}

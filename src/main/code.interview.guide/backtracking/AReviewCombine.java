package backtracking;

import java.util.ArrayList;
import java.util.List;

// lt 77
// 写错成起始点不用start，需要写成下标i；
public class AReviewCombine {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) return res;
        List<Integer> list = new ArrayList<Integer>();
        process(list, n, 1,k);
        return res;
    }

    private void process(List<Integer> list, int end, int start, int k) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        } else {
            for (int i = start; i <= end; i++) {
                list.add(start);
                process(list,end,start+1,k-1);
                list.remove(list.size()-1);
            }
        }
    }
}

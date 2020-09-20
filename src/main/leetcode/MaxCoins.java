import java.util.ArrayList;
import java.util.List;

public class MaxCoins {
    int res = 0;
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        dfs(list,0);
        return res;
    }

    private void dfs(List<Integer> list,int coins) {
        if (list.size() == 0) {
            res = Math.max(res,coins);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            int all = list.get(i) * (i - 1 < 0? 1 : list.get(i-1)) * (i+1 >= list.size()? 1:list.get(i+1));
            list.remove(i);
            dfs(list,coins+all);
            list.add(i,temp);
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class L216 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k > 9 || n > (19 - k) * k / 2) return res;
        List<Integer> list = new ArrayList<Integer>();
        process(list,k,n,0);
        return res;
    }

    private void process(List<Integer> list, int remainK, int remain, int start) {
        if (remain == 0 && remainK == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if (remain < 0 || remainK < 0) {
            return;
        }
        for (int i = start; i <= 9; i++){
            list.add(i);
            process(list,remainK - 1,remain - i,start + 1);
            list.remove(list.size()-1);
        }
    }
}

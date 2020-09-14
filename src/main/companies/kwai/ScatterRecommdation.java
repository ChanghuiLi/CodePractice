package kwai;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ScatterRecommdation {
    public static void main(String[] args) {
    }
    public List<String> Solution(List<String> input, int n) {
        List<String> res = new ArrayList<String>();
        Queue<String> queueSaveP = new LinkedList<String>();
        Queue<String> queueSaveV = new LinkedList<String>();
        int index = 0;
        while (index < input.size() && input.get(index).charAt(0) == 'V') {
            res.add(input.get(index));
            index++;
        }
        if (index < input.size()&& input.get(index).charAt(0) == 'P') {
            res.add(input.get(index));
            index++;
        }
        int countP = 0,countV = 0;
        for (int i = index; i < input.size(); i++) {
            if (input.get(i).charAt(0) == 'V') {
                queueSaveV.add(input.get(i));
                countV++;
            }
            if (input.get(i).charAt(0) == 'P'){
                queueSaveP.add(input.get(i));
                countP++;
            }
            if (countV >= n-1 && countP > 0){
                int tempV = n-1;
                while (tempV > 0){
                    res.add(queueSaveV.poll());
                    countV--;
                }
                res.add(queueSaveP.poll());
                countP--;
            }
        }
        int outv = 0;
        while (!queueSaveV.isEmpty() && outv < n-1) {
            res.add(queueSaveV.poll());
            outv++;
        }
        return res;
    }
}

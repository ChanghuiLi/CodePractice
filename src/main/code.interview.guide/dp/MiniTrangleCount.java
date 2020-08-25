package dp;

import javafx.scene.shape.TriangleMesh;

import java.util.List;

public class MiniTrangleCount {
    public static void main(String[] args) {
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int[] dp = new int[triangle.get(triangle.size()-1).size()];
        dp[0] = triangle.get(0).get(0);
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> temp = triangle.get(i);
            dp[temp.size()-1] = temp.get(temp.size()-1) + dp[temp.size()-2];
//            int tempvalue = dp[temp.size()-2];
            for(int j = temp.size()-2; j > 0; j--) {
                dp[j] = Math.min(dp[j],dp[j-1]) + temp.get(j);
            }
            dp[0] = dp[0] + temp.get(0);
        }
        int tempmin = dp[0];
        for(int i = 1; i < dp.length; i++){
            tempmin = Math.min(tempmin,dp[i]);
        }
        return tempmin;
    }
}

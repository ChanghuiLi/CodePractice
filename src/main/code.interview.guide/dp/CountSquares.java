package dp;
/**
 * 确认清楚输入和输出。
 * 当定义的dp状态的下标和原始matrix下标不一致的时候，需要进行特殊处理（-1的操作）。
 * */

public class CountSquares {
    public int countSquares(int[][] matrix) {
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for (int i = 1; i <= dp.length; i++) {
            for (int j = 1; j <= dp[0].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                    res += dp[i][j];
                }
            }
        }
        return dp[matrix.length][matrix[0].length];
    }
}

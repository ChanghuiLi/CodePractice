package kwai;

public class AreviewDropEgg {
    public int Solution(int eggs, int level) {
        int[][] dp = new int[eggs+1][level+1];
        // 初始化
        for (int i = 0; i <= level; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int j = 1; j <= eggs; j++) {
            dp[1][j] = j;
        }
        // 定义状态为dp[i][j] = i个鸡蛋，j层需要最小的测试次数。
        for (int i = 2; i <= eggs; i++) {
            for (int j = 2; j <= level; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // dp[i][j] = max(dp[i-1][k-1],dp[i][j-k])[k--->(1,j)]
                for (int k = 1; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[i][j-k],dp[i-1][k-1]));
                }
            }
        }
        return dp[eggs][level];
    }
}

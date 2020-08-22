package dp;
/**
 * 做算法题前想清楚特殊情况处理；
 * 原始初始化是否合理;
 * */
public class MiniCoins {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int aim = 10;
        System.out.println(minCoin1(arr,aim));
    }
    public static int minCoin1(int[] arr,int aim){
        if (aim <= 0) return 0;
        int res = 0;
        // 定义状态
        int[] dp = new int[aim+1];
        for(int i = 0;i <= aim;i++){
            dp[i] = -1;
        }
        int temp = 0;
        // 状态初始化
        for(int i = 0; i < arr.length; i++){
            if (arr[i] <= aim) {
                dp[arr[i]] = 1;
                for(int j = arr[i]+1; j <= aim; j++){
                    // 状态转移方程
                    if (dp[j-arr[i]] != -1) {
                        if (dp[j] == -1) {
                            dp[j] = dp[j - arr[i]] + 1;
                        } else {
                            dp[j] = Math.min(dp[j - arr[i]] + 1, dp[j]);
                        }
                    }
                }
            }
        }
        for(int i = 0;i<= aim;i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        return dp[aim];
    }
}

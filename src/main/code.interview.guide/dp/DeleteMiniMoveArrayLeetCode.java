package dp;
/**
 *  LeetCode 1246；
 *  错误点在于状态转移方程;
 *  区间动态规划，可以获取中间状态的区间，进行遍历获得最优解。dp[i][k]+dp[k+1][j]
 * */
public class DeleteMiniMoveArrayLeetCode {
    public static void main(String[] args) {
        int[] nums = {16,13,13,10,12};
        System.out.println(minimumMoves(nums));
    }
    public static int minimumMoves(int[] arr) {
        if (arr.length <= 1 ) return arr.length;
        // 定义dp状态
        int[][] dp = new int[arr.length][arr.length];
        // 状态初始化
        dp[0][0] = 1;
        for(int i = 1; i < arr.length; i++){
            dp[i][i] = 1;
            dp[i-1][i] = arr[i-1] == arr[i]? 1 : 2;
        }
        // 状态转移方程
        for(int i = arr.length - 2; i >= 0; i--){
            for(int j = i + 2; j <= arr.length-1; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]);
                }
                if (arr[i]==arr[j]) dp[i][j] = Math.min(dp[i+1][j-1],dp[i][j]);
            }
        }

        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][arr.length-1];
    }
}

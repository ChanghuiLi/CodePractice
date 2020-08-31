package dp;
/**
 * temp = Math.max(temp, dp[j]) + 1;
 * 这样是错误的，会导致每次大于dp【i】temp都会被+1；
 *
 * */
public class LIS {
    public int lengthOfLIS(int[] nums) {
         if (nums.length <= 1 ) return nums.length;
         int[] dp = new int[nums.length];
         dp[0] = 1;
         int temp = 1;
         for(int i = 1; i < nums.length; i++){
             temp = 1;
             for(int j = i-1; j >= 0; j--){
                 if (nums[i] > nums[j]) {
                     temp = Math.max(temp, dp[j] + 1);
                 }
             }
             dp[i] = temp;
         }

         int res = dp[0];
         for(int i = 1; i < nums.length; i++){
             res = Math.max(res,dp[i]);
         }
         return res;
    }
}

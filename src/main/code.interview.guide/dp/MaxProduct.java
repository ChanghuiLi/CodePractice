package dp;
/** 敢想敢写
 *
 * */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        int currmax = nums[0];
        int currmin = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tempmax = currmax * nums[i];
            int tempmin = currmin * nums[i];
            currmax = Math.max(Math.max(tempmin, tempmax),nums[i]);
            currmin = Math.min(Math.min(tempmin,tempmax),nums[i]);
            res = Math.max(currmax,res);
        }
        return res;
    }
}

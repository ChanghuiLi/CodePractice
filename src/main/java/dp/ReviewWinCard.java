package dp;
/** 递归可以调用另外一个的递归函数。不一定要自己调用自己。可以两个函数之间相互递归调用。
 * 递归是自顶向下，存在重复计算的步骤。动态规划是自底向下。一般递归都可以用动态规划来求解，通过用DP状态来存储中间的计算值。
 * 存储状态不一定要在一个状态存储介质里。可以是存储两个状态。在两个状态中相互利用，进行相互的状态转换。
 * */
public class ReviewWinCard {
    public static void main(String[] args) {
        int[] nums = {100,2,4,31,5,3,46,32,67,23,57,12};
        System.out.println(win(nums));
        System.out.println(DpWin(nums));

    }

    public static int win(int[] nums){
        if(nums.length==1) return nums[0];
        return Math.max(Preget(nums, 0, nums.length-1), backget(nums,0,nums.length-1));
    }

    // 先手最大值
    private static int Preget(int[] nums, int s, int e) {
        if(s == e){
            return nums[s];
        }
        return Math.max(nums[s] + backget(nums, s+1, e), nums[e] + backget(nums, s, e-1));
    }

    // 后手最大值
    private static int backget(int[] nums, int s, int e) {
        if(s == e){
            return 0;
        }
        return Math.min(Preget(nums,s+1,e),Preget(nums,s,e-1));
    }

    public static int DpWin(int[] nums){
        int[][] preget = new int[nums.length][nums.length];
        int[][] backget = new int[nums.length][nums.length];
        for(int i = 0; i < nums.length; i++){
            preget[i][i] = nums[i];
        }
        for(int e = 1; e < nums.length; e++){
            for(int s = e - 1; s >= 0; s--){
                preget[s][e] = Math.max(nums[s]+backget[s+1][e],nums[e]+backget[s][e-1]);
                backget[s][e] = Math.min(preget[s+1][e],preget[s][e-1]);
            }
        }
        return Math.max(backget[0][nums.length-1],preget[0][nums.length-1]);
    }
}

package dp;
/**递归可以调用另外一个的递归函数。不一定要自己调用自己。可以两个函数之间相互递归调用。
 *
 * */
public class ReviewWinCard {
    public static void main(String[] args) {

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




}

package dp;

public class Fibonacci {
    public static void main(String[] args) {

    }
    /**
     * dp[i] = dp[i-1]+dp[i-2]; 并不需要一个数组，存储前两个状态就可以。
     *
     * @param nums
     * */
    public static int f1(int nums) throws Exception{
        if (nums == 1||nums == 2) return 1;
        int res = 1;
        int pre = 1;
        int temp = 0;
        for(int i = 3; i <= nums; i++){
            temp = res;
            res = pre + res;
            pre = temp;
        }
        return res;
    }
}

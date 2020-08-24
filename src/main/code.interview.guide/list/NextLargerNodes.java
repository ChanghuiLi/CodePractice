package list;

public class NextLargerNodes {
    public static void main(String[] args) {
    }
    public int[] nextLargerNodes(ListNode head) {
        if(head == null || head.next == null) return new int[1];
        int len = 1;
        ListNode prehead = head;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        int[] nums = new int[len];
        int[] dp = new int[len];
        for(int i = 0; i < nums.length; i++){
            nums[i] = prehead.val;
            prehead = prehead.next;
        }
        dp[len-1] = 0;
        dp[len-2] = nums[len-2] < nums[len-1]? nums[len-1]:0;
        for(int i = len-3; i >=0; i--){
            if (nums[i] == nums[i+1]) {
                dp[i] = dp[i+1];
            } else if (nums[i] < nums[i+1]){
                if (dp[i+1] == 0) {
                    dp[i] = nums[i+1];
                }else{
                    dp[i] = dp[i+1];
                }
            } else {
                int temp = 0;
                for(int j = i+1;j < nums.length; j++){
                    if(dp[j] > nums[i]){
                        temp = Math.min(dp[j],temp);
                    }
                }
            }
        }
        return dp;
    }
}

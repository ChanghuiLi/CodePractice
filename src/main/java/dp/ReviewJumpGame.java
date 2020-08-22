package dp;

public class ReviewJumpGame {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,1,4};
        System.out.println(Jump(nums));
        System.out.println(Jump2(nums));

    }

    /**
     * 时间和空间复杂度均为O（N）
     * */
    public static int Jump(int[] nums){
        int[] dpJumpStep = new int[nums.length];
        int position = 0;
        for(int i = 0; i < nums.length-1; i++){
            for(int tempstep = nums[i]; tempstep > 0; tempstep--){
                position = i + tempstep;
                if (position < nums.length) {
                    if (dpJumpStep[position] == 0) {
                        dpJumpStep[position] = dpJumpStep[i] + 1;
                    }else{
                        dpJumpStep[position] = Math.min(dpJumpStep[i] + 1,dpJumpStep[position]);
                    }
                }
            }
        }
        return dpJumpStep[nums.length-1];
    }
    /**
     * 时间复杂度为O（n），空间复杂度为O（1）
     * jump 跳的步长；
     * curr 跳jump步能达到的最长位置；
     * next 再多条一步所能达到的位置。
     * */
    public static int Jump2(int[] nums){
        if(nums.length == 1) return 0;
        int jump = 1;
        int curr = nums[0];
        int next = 0;
        for(int i = 1;i < nums.length; i++){
            if (curr < i) {
                jump++;
                curr = next;
            }
            next = Math.max(next,nums[i]+i);
        }
        return  jump;
    }

}

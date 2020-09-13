package binarysearch;

public class searchRange {
    public static void main(String[] args) {
        int[] nums = {0,0,1,2,2};
        int target = 2;
        int[] res = searchRange(nums,target);
        System.out.println(res[0]+"   "+res[1]);
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if (nums == null || nums.length <= 0) return res;
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid - 1;
                right = mid + 1;
                while (left >= 0 && nums[left] == target) {
                    left--;
                }
                while (right < nums.length && nums[right] == target){
                    right++;
                }
                res[0] = left + 1;
                res[1] = right - 1;
                return res;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}

package binarysearch;

public class binaysearchbase {
    public static void main(String[] args) {
        int[] nums = {1,3,4,6,8};
        System.out.println(searchInsert(nums,-1));
    }
    public static int binarysearch(int[] nums,int target){
        if (nums == null || nums.length == 0
                || nums[0] > target || nums[nums.length-1] < target) return -1;
        int res = -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length-1]) return nums.length;
        if (target < nums[0]) return 0;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (target > nums[mid]) {
            return mid + 1;
        } else {
            return mid;
        }

    }
}

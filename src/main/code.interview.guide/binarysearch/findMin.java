package binarysearch;
// L81
public class findMin {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = -1;
        int start = 0;
        int end = nums.length-1;
        if (nums[start] < nums[end]) return start;
        if (nums.length == 1) return 0;

        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > nums[mid+1]) {
                return mid + 1;
            }
            if (nums[mid-1] > nums[mid]) {
                return mid ;
            }
            if (nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}

package microsoft;

public class SumArray {
    public int Solution(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null
                || nums1.length != nums2.length || nums1.length <= 0) return -1;

        long res = 0;
        for (int i = 0; i < nums1.length; i++) {
            res += ((long)nums1[i] * (long)nums2[i]);
        }
        return (int)res;
    }
}

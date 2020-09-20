package baidu;
// 两个有序数组求最小；
public class SquenceMin {
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,7};
        int[] nums2 = {8};
        System.out.println(min(nums1,nums2));
     }
    public static int min(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return -1;
        }
        int indexNums1 = 0;
        int indexNums2 = 0;
        while (indexNums1 < nums1.length && indexNums2 < nums2.length) {
            if (nums1[indexNums1] == nums2[indexNums2]) {
                return nums1[indexNums1];
            }
            while (indexNums1 < nums1.length && indexNums2 < nums2.length
                    && nums1[indexNums1] < nums2[indexNums2]) {
                indexNums1++;
            }
            while (indexNums1 < nums1.length && indexNums2 < nums2.length
                    && nums1[indexNums1] > nums2[indexNums2]) {
                indexNums2++;
            }
        }
        return -1;
    }
}

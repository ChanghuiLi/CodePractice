package binarysearch;

public class findBadVersion {
//    LintCode 74
    public int findFirstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = (start + end)/2;
            if (isBadVersion(start) != isBadVersion(start+1)) {
                return start+1;
            }
            if (isBadVersion(end) != isBadVersion(end-1)) {
                return end;
            }
            if (isBadVersion(mid) == false) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}

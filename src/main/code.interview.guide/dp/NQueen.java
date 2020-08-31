package dp;
/**
 *  可以用二维dp[i][j] 来存储具体的表格。
 *  或者用dp[i] = j来存储第i行的第j个元素有值。
 *
 * */
public class NQueen {
    public int queue(int n) {
        if (n <= 1) return 1;
        int[][] record = new int[n][n];
        return helper(0,n,record);
    }

    private int helper(int i, int n, int[][] record) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isVaild(i,j,record)) {
                record[i][j] = 1;
                res += helper(i+1,n,record);
            }
        }
        return res;
    }

    private boolean isVaild(int i, int j, int[][] record) {
        return true;
    }
}

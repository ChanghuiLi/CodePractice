package microsoft;

public class RemoveBottle {
    public static void main(String[] args) {
        int[] nums = {1,3,4,11,23,12,4,5};
        takeAwayTheBottle(nums);
        System.out.println();
        takeAwayTheBottle2(nums);

    }
    public static int takeAwayTheBottle2(int[] arr) {
        // Write your code here.
        // Write your code here.
        // 定义i，j对应的start，end的位置；
        int[][] dp = new int[arr.length][arr.length];
// Write your code here.
        int i, j, k, l;
        int n = arr.length;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) dp[i][j] = n;
        }

        for (i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (i = 0; i + 1 < n; i++) {
            if (arr[i] == arr[i + 1]) dp[i][i + 1] = 1;
            else dp[i][i + 1] = 2;
        }
        for (l = 2; l < n; l++) {
            for (i = 0; i + l < n; i++) {
                j = i + l;
                if (arr[i] == arr[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                for (k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
            }
        }
        for (int i1 = 0; i1 < dp.length; i1++) {
            for (int j1 = 0; j1 < dp.length;j1++){
                System.out.print(dp[i1][j1]+" ");
            }
            System.out.println();
        }
        return dp[0][n - 1];
    }
    public static int takeAwayTheBottle(int[] arr) {
        // Write your code here.
        // 定义i，j对应的start，end的位置；
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < arr.length; j++) {
            if (arr[j-1] == arr[j]) {
                dp[j-1][j] = 1;
            } else {
                dp[j-1][j] = 2;
            }
        }
        for (int col = 2; col < arr.length; col++) {
            for (int row = col - 2; row >= 0; row--) {
                if (arr[col] == arr[row]) {
                    dp[row][col] = dp[row+1][col-1];
                } else {
                    int temp = Integer.MAX_VALUE;
                    for(int m = col; m > row; m--) {
                        temp = Math.min(dp[m][col]+dp[row][m - 1], temp);
                    }
                    dp[row][col] = temp;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][arr.length-1];
    }
}

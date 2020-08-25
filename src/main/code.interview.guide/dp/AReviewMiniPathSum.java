package dp;
/** 二维数组的dp，一般可以压缩空间。
 *  初始化错误：初始状态应该是一个叠加状态。
 *  迭代公式错误：迭代公式没有加上当前的点。
 * */
public class AReviewMiniPathSum {
    public static void main(String[] args) {
        int[][] m = {{1,3,5,9}};
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[0].length; j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(minPath(m));
        System.out.println(minPath2(m));

    }
    public static int minPath(int[][] m){
        // 定义状态
        int[][] dp = new int[m.length][m[0].length];
        // 初始化dp矩阵
        dp[0][0] = m[0][0];
        for(int i = 1; i < m[0].length; i++){
            dp[0][i] = m[0][i] + m[0][i-1];
        }
        for(int i = 1; i < m.length; i++){
            dp[i][0] = m[i][0] + m[i-1][0];
        }
        // 状态转移方程
        for(int i = 1; i < m.length; i++){
            for(int j = 1; j < m[0].length; j++){
                dp[i][j] = m[i][j]+Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m.length-1][m[0].length-1];
    }

    /**
     * 空间复杂度优化，上面方法的空间复杂度高，能不能降低空间复杂度。
     * 存储状态一个数组就可以了,min(m,n)
     * */
    public static int minPath2(int[][] m){
        int row = m.length;
        int col = m[0].length;
        int[] dp = new int[col];
        dp[0] = m[0][0];
        for(int i = 1; i < m[0].length; i++){
            dp[i] = m[0][i] + m[0][i-1];
        }
        for(int i = 1; i < m.length; i++){
            dp[0] = m[i][0];
            for(int j = 1; j < row; j++){
                dp[j] = m[i][j] + Math.min(dp[j-1], dp[j]);
            }
        }
        return dp[col-1];
    }
}

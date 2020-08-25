package dp;
/**
 * 矩阵压缩的话，涉及到元素变动，会更改原来的状态值，需要用一个元素将其存储起来。
 * */
public class AReviewRobotWalk {
    public static void main(String[] args) {
        System.out.println(HelpWalk(5,2,3,3));
        System.out.println(HelpWalk2(5,2,3,3));
        System.out.println(HelpWalk3(5,2,3,3));

    }

    public static int Walk(int N,int M,int K,int P){
        if (N <= 0|| M > N || P > N|| K <0){
            return 0;
        }
        return HelpWalk(N,M,K,P);
    }

    private static int HelpWalk(int N, int cur, int rest, int target) {
        if (rest == 0){
            return cur == target? 1 : 0;
        }
        if (cur == 1) {
            return HelpWalk(N,2,rest-1,target);
        }
        if (cur == N) {
            return HelpWalk(N,N-1,rest -1,target);
        }
        return HelpWalk(N,cur-1,rest-1,target) + HelpWalk(N,cur+1,rest-1,target);
    }

    // 递归转化为动态规划，
    private static int HelpWalk2(int N, int cur, int rest, int target) {
        // 定义状态
        int[][] dp = new int[rest+1][N+1];
        dp[0][target] = 1;
        for(int i = 1; i <= rest; i++){
            for(int j = 1; j <= N; j++){
                if (j == 1) {
                    dp[i][1] = dp[i-1][2];
                }else if (j == N) {
                    dp[i][N] = dp[i-1][N-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
            }
        }
        return dp[rest][cur];
    }

    // 二维动态规划，矩阵压缩
    private static int HelpWalk3(int N,int cur,int rest,int target){
        int[] dp = new int[N+1];
        dp[target] = 1;
        int left = 0;
        int temp = 0;
        for(int i = 1;i <= rest;i++){
            left = dp[1];
            for(int j = 1; j <= N;j++){
                temp = dp[j];
                if (j == 1) {
                    dp[1] = dp[2];
                } else if (j == N) {
                    dp[N] = left;
                } else {
                    dp[j] = left + dp[j+1];
                }
                left = temp;
            }
        }
        return dp[cur];
    }
}

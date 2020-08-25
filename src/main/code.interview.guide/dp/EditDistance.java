package dp;
/**
 * dp[i][j] Str1【0--i】变化到Str2【0---j】
 *
 * */
public class EditDistance {

    public int miniCost(String str1, String str2,int dc,int ic,int rc){
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        // 初始化DP
        for(int i = 1; i < dp.length;i++){
            dp[i][0] = dc * 1;
        }

        for(int j = 1; j < dp[0].length; j++){
            dp[0][j] = ic * j;
        }

        for(int i = 1;i < dp.length; i++){
            for(int j = 1; j < dp.length; j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j] + dc;
                }
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+rc);
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+ic);
            }
        }
        return dp[str1.length()-1][str2.length()-1];
    }
}

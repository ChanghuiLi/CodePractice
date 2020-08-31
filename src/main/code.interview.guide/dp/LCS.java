package dp;
/**
 * 最长公共子序列
 * 2020-08-30 最长公共子序列：dp状态更新的时候。注意charAt（i）和charAt（j）与dp的下标对应的可能是不同的。
 * 对空间进行压缩的化，注意每一次更新迭代到最后。进行下一次更新的时候。初始记录的上一轮状态要重制。
 * */
public class LCS {
    public static void main(String[] args) {
        String str1 = "hofubmnylkra"
        ;
        String str2 = "pqhgxgdofcvmr";
        System.out.println(longestCommonSubsequence(str1,str2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null||text1.length() == 0||text2 == null||text2.length() == 0) {
            return 0;
        }
        // dp[i][j] 表示text1从0--i子串与text2的0--j子串的最长公共子串长度。
        int[] dp = new int[text2.length()+1];
        int tempvalue2 = 0;
        int tempvalue = 0;
        for(int i = 1;i <= text1.length();i++){
            dp[0] = 0;
            tempvalue = 0;
            for(int j = 1;j <= text2.length();j++){
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    tempvalue2 = dp[j-1] + 1;
                } else {
                    tempvalue2 = Math.max(dp[j],tempvalue);
                }
                dp[j-1] = tempvalue;
                tempvalue = tempvalue2;
                System.out.print(dp[j]+" ");
            }
            dp[text2.length()] =tempvalue;
            System.out.println();
        }
        return tempvalue;
    }
}

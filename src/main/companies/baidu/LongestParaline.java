package baidu;

public class LongestParaline {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 1;
        int longestStart = 1;
        int longestEnd = 1;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < s.length(); j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(j)==s.charAt(i) && i == j - 1) {
                    dp[i][j] = true;
                    if (res < 2) {
                        longestEnd = j;
                        longestStart = i;
                        res = 2;
                    }
                }
                if (s.charAt(j) == s.charAt(i) && dp[i+1][j-1] == true) {
                    dp[i][j] = true;
                    if (res < j-i+1) {
                        longestEnd = j;
                        longestStart = i;
                        res = j - i + 1;
                    }
                }
            }
        }
        System.out.println(res);
        return s.substring(longestStart, longestEnd+1);
    }
}

package offerII;

/**
 *最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class Offer095 {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

    /**
     * 子串可间隔字符或不间隔
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1.equals("") || text2.equals("")) {
            return 0;
        }
        int maxLen = 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1]; // 动态规划记录长度
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return maxLen;
    }

    /**
     *最长公共子串-子串连续不断
     * @param str1
     * @param str2
     * @return
     */
    public String LCS (String str1, String str2) {
        // write code here
        if (str1 == null || str2 == null || str1.equals(" ") || str2.equals(" ")) {
            return "-1";
        }
        //动态规划  二维数组，斜下来就是最长字串
        int str1len = str1.length();
        int str2len = str2.length();
        int maxLen = 0;
        int index = 0;
//        定义一个二维数组
        int[][] dp = new int[str1len][str2len];
        //第一步：划分
        for (int i = 0; i < str1len; i++) {
            for (int j = 0; j < str2len; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (j == 0 || i == 0){
                        dp[i][j]=1;
                        if (maxLen == 0) {
                            maxLen = dp[i][j];
                            index = i;
                        }
                    } else{
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        if(maxLen <= dp[i][j]){
                            maxLen = dp[i][j];
                            index = i;
                        }
                    }
                }
            }
        }
        if( maxLen==0 ){
            return "-1";
        }
        return str1.substring(index-maxLen+1,index+1);
    }
}

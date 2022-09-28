package interview;

/**
 * 第k 个数
 */
public class interview1709 {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k+ 1];
        dp[1] = 1;
        int d3 = 1, d5 = 1, d7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[d3]*3, num5 = dp[d5]*5, num7 = dp[d7]*7;
            dp[i] = Math.min(Math.min(num3, num5), num7);
            if (dp[i] == num3) {
                d3++;
            }
            if (dp[i] == num5) {
                d5++;
            }
            if (dp[i] == num7) {
                d7++;
            }
        }
        return dp[k];
    }
}

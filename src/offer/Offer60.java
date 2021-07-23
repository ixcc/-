package offer;

import java.util.Arrays;

public class Offer60 {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6]; // 动态规划定义数组初始默认长度为6
        Arrays.fill(dp,1.0/6.0); // 初始值
        // i为骰子个数
        for (int i = 2; i <= n; i++){
            double[] temp = new double[i * 6 - i + 1]; // 中间变量数组
            // j为骰子和的值
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] * (1.0/6.0);
                }
            }
            dp = temp;
        }
        return dp;
    }
}

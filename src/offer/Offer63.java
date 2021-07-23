package offer;

public class Offer63 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; // 当前下标之前最小的值
        int count = 0; // 当前下标前利益最大化的差值
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]); // 当前值与之前的最小值比较谁最小
            count = Math.max(count, prices[i] - min); // 之前利益最大值与当前下标与之前最小差值比较谁更大
        }
        // 返回最大利益值就行
        return count;
    }

    public int maxProfit2(int[] prices) {
        int min = Integer.MAX_VALUE; // 当前下标之前最小的值
        int count = 0; // 当前下标前利益最大化的差值
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
               min = prices[i];
            } else if (count < prices[i] - min) {
                count = prices[i] - min;
            }
        }
        // 返回最大利益值就行
        return count;
    }
}

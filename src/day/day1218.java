package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长定差子序列
 */
public class day1218 {
    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }

    /**
     * 哈希表+动态规划
     * @param arr
     * @param difference
     * @return
     */
    public static int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(arr[0], 0);
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {

            int temp = arr[i] - difference;
            if (map.containsKey(temp) && map.get(temp) < i) {
                dp[i] = dp[map.get(temp)] + 1;
            } else {
                dp[i] = 1;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
            map.put(arr[i], i);
        }
        return max;
    }

    /**
     * 简洁方式
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence2(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<Integer, Integer>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }

}

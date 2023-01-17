package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一个数组中的好对子的数目
 */
public class day1814 {

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod = 1000000007;
        int res = 0;
        for (int n : nums) {
            int temp = n, j = 0;
            while (temp > 0) {
                j = j*10 + temp % 10;
                temp = temp/10;
            }
            res = (res + map.getOrDefault(n - j, 0)) % mod;
            map.put(n - j, map.getOrDefault(n - j, 0) + 1);
        }
        return res;
    }
}

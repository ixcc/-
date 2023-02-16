package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组能形成多少数对
 */
public class day2341 {

    /**
     * 哈希表
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int sum = 0;
        int yu = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getValue()/2;
            yu += entry.getValue()%2;
        }
        arr[0] = sum;
        arr[1] = yu;
        return arr;
    }
}

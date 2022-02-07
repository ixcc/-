package offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * 个数相同的子数组
 */
public class Offer011 {

    /**
     * map存放前缀和
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int count = 0;
        map.put(count, -1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                int number = map.get(count);
                maxLen = Math.max(maxLen, i - number);
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}

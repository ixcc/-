package offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字
 */
public class Offer03 {

    /**
     * 哈希表方式
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
//        Map<Integer, Boolean> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                return num;
//            } else {
//                map.put(num, true);
//            }
//        }
//        return 0;
    }

    /**
     *  原地交换--数组
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int index = 0;
        while (index <= nums.length - 1) {
            // 下标元素等于下标对应值
            if (nums[index] == index) {
                index++;
                continue;
            }
            // 找到重复元素
            if (nums[index] == nums[nums[index]]) {
                return nums[index];
            }
            // 原地交换数组值
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}

package offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Offer39 {

    public int majorityElement(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
//            map.put(nums[i],count + 1);
//            if (count + 1 > n/2) {
//                return nums[i];
//            }
//        }
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n/2 + 1; i++) {
            int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
            map.put(nums[i],count + 1);
        }
        for (int i = n/2 + 1; i < n; i++) {
            int count = map.containsKey(nums[i]) ? map.get(nums[i]) : 0;
            map.put(nums[i],count + 1);
            if (count + 1 > n/2) {
                return nums[i];
            }
        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement3(int[] nums) {
        int x = 0, sum = 0;
        for (int num : nums) {
            if (sum == 0) {
                x = num;
            }
            sum += x == num ? 1 : -1;
        }
        // 非必须存在众数时验证
        //拓展:由于题目说明 给定的数组总是存在多数元素 ，因此本题不用考虑 数组不存在众数 的情况。
        // 若考虑，需要加入一个 “验证环节” ，遍历数组 nums 统计 x 的数量。
//        int count = 0;
//        for (int num : nums) {
//            if (num == x) {
//                count++;
//            }
//        }
//        return count > nums.length/2 ? x : 0;
        return x;
    }
}

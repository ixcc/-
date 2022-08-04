package day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 非递增顺序的最小子序列
 */
public class day1403 {

    /**
     * 排序
     * @param nums
     * @return
     */
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count+= nums[i];
        }
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            count -= nums[i];
            list.add(nums[i]);
            if (sum > count) {
                return list;
            }
        }
        return list;
    }
}

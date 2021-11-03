package offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中和为0的三个元素
 */
public class Offer007 {


    /**
     * 数组排序 + 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        // 边界值处理
        if (len < 3) {
            return ans;
        }
        // 数组排序
        Arrays.sort(nums);
        // 遍历数组
        for (int i = 0; i < len; i++) {
            // 超过条件判断
            if (nums[i] > 0) {
                return ans;
            }
            // 重复值去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int cur = nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int count = cur + nums[left] + nums[right];
                if (count == 0) {
                    // 将符合条件的数字存入集合
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    // 去掉left重复情况
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去掉right重复情况
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 移动指针
                    right--;
                    left++;
                } else if (count > 0) {
                    right--;
                } else if (count < 0) {
                    left++;
                }
            }
        }
        return ans;
    }

}

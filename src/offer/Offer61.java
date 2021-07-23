package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Offer61 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0; // 大小王出现次数
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++; // 大小王数量加一
            } else if (nums[i] == nums[i + 1]) {
                // 不是大小王且两个值重复--立即返回false
                return false;
            }
        }
        // 判断最大值与最小值的差值是否满足小于5--为真则返回true
        return nums[4] - nums[joker] < 5;
    }

    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14; // 定义变量记录数组的最大最小值
        for (int i = 0; i <= 4; i++) {
            // 遇到大小王跳过
            if (nums[i] == 0) {
                continue;
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
            // set中是否已经存在该数字--存在立即返回false
            if (repeat.contains(nums[i])) {
                return false;
            } else {
                // 否则追加近set
                repeat.add(nums[i]);
            }

        }
        // 判断最大值与最小值的差值是否满足小于5--为真则返回true
        return max - min < 5;
    }
}

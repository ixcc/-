package day;

public class day26 {

    public int removeDuplicates(int[] nums) {
        // 数值边界值情况处理
        if (nums.length <= 1) {
            return nums.length;
        }
        // 定义快慢指针
        int low = 0, fast = 1;
        while (fast <= nums.length - 1) {
            if (nums[low] != nums[fast]) {
                // 替换数组位置
                low++; // 第一个重复的数字
                nums[low] = nums[fast]; // 用重复后的元素替换到重复的元素位置
            }
            fast++; // 快指针一直往后遍历
        }
        // 返回的长度为慢指针下标加一
        return low + 1;
    }
}

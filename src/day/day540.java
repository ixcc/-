package day;

/**
 * 有序数组中的单一元素
 */
public class day540 {

    /**
     * 异或运算
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }

    /**
     * 二分法
     * @param nums
     * @return
     */
    public int singleNonDuplicate2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (right - left) / 2 + left;
            middle -= middle & 1; // 保证mid是偶数则不变，奇数则减去1
            if (nums[middle] == nums[middle + 1]) {
                left = middle + 2;
            } else {
                right = middle;
            }
        }
        return nums[left];
    }
}

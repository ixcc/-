package day;

/**
 * 数组中两元素的最大乘积
 */
public class day1464 {

    /**
     * 一次遍历
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > num1) {
                num2 = num1;
                num1 = nums[i];
                continue;
            }
            if (nums[i] > num2) {
                num2 = nums[i];
                continue;
            }
        }
        return (num1 - 1) * (num2 - 1);
    }
}

package day;

/**
 * 逐步求和得到最小值
 */
public class day1413 {

    /**
     * 一次遍历贪心
     * @param nums
     * @return
     */
    public int minStartValue(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
            if (nums[i] < sum) {
                sum = nums[i];
            }
        }
        if (sum < 1) {
            return 1 - sum;
        } else {
            return 1;
        }
    }
}

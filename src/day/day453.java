package day;

/**
 * 最小操作次数使得元素值相等
 */
public class day453 {

    /**
     * 找到最小值，每个值与最小值的差值
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int change = 0;
        for (Integer num : nums) {
            change += num - min;
        }
        return change;
    }
}

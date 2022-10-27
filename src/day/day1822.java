package day;

/**
 * 数组元素积的符号
 */
public class day1822 {

    /**
     * 判断负数的个数
     * @param nums
     * @return
     */
    public int arraySign(int[] nums) {
        int sign = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                sign++;
            }
        }
        return sign%2 == 0 ? 1 : -1;
    }
}

package day;

/**
 * 全局倒置与局部倒置
 */
public class day775 {

    /**
     * 归纳分析，每个元素与该元素下标差值不能大于1
     * @param nums
     * @return
     */
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}

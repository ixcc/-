package offer;

/**
 * 子数组最大和
 */
public class Offer42 {

    /**
     * 不改变原数组
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sumMax = nums[0];
        int sumNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sumNow = Math.max(sumNow + nums[i], nums[i]);
            if (sumNow >= sumMax) {
                sumMax = sumNow;
            }
        }
        return sumMax;
    }

    /**
     * 更改原数组
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int count = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            count = Math.max(nums[i], count);
        }
        return count;
    }
}

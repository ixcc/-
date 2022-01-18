package offerII;

/**
 * 乘积小于K的子数组
 */
public class Offer009 {

    /**
     * 滑动窗口
     * 每次窗口固定right边界：值为right - left + 1
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length - 1;
        int count = 1;
        int left = 0, right = 0;
        int num = 0;
        for (; right <= len; right++) {
            count *= nums[right];
            while (count >= k && left < right) {
                count /= nums[left];
                left++;
            }
            if (count < k) {
                num += right - left + 1;
            }
        }
        return num;
    }
}

package offerII;

/**
 * 左右两边子数组和相等
 */
public class Offer012 {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int rightCount = 0;
        int leftCount = 0;
        for (int i = 0; i < nums.length; i++) {
            rightCount += nums[i];
        }
        for (int j = 0; j < nums.length; j++) {
            rightCount -= nums[j];
            if (rightCount == leftCount) {
                return j;
            } else {
                leftCount += nums[j];
            }
        }
        return -1;
    }
}

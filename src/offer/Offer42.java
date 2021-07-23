package offer;

public class Offer42 {

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
}

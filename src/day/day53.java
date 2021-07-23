package day;

public class day53 {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length - 1; i++) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i]);
            if (nums[i] > res) {
                res = nums[i];
            }
        }
        return res;
    }
}

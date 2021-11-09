package offerII;

/**
 * 环形房屋偷盗
 */
public class Offer090 {

    /**
     * 比较[0,n -1] 和[1, n]的数值大小
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        return Math.max(myRob(nums, 0, len - 1), myRob(nums, 1, len));

    }

    /**
     * 动态规划比较前一个和前两个+当前值大小
     * right = Math.max(right, left + nums[i])
     * @param nums
     * @param begin
     * @param len
     * @return
     */
    public int myRob(int[] nums, int begin, int len) {
        int left = 0, right = 0, temp;
        for (int i = begin; i < len; i++) {
            temp = right;
            right = Math.max(right, left + nums[i]);
            left = temp;
        }
        return right;
    }
}

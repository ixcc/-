package offerII;

/**
 * 和大于等于目标值的最短路径
 */
public class Offer008 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int count = nums[0];
        int left = 0, right = 0;
        int len = nums.length - 1;
        while (right < len || count >= target) {
            if (count < target && right < len) {
                right++;
                count += nums[right];
            } else if (count >= target) {
                minLen = Math.min(minLen, (right - left + 1)) ;
                left++;
                count -= nums[left];
                if (count >= target && left == right) {
                    return 1;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

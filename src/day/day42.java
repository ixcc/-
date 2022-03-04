package day;

/**
 * 接雨水
 */
public class day42 {

    /**
     * 动态规划
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[len];
        rightMax[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(rightMax[i], leftMax[i]) - height[i];
        }
        return ans;
    }

    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int count = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (height[left] > height[right]) {
                count += rightMax - height[right];
                right--;
            } else {
                count += leftMax - height[left];
                left++;
            }
        }
        return count;
    }
}

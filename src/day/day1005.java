package day;

import java.util.Arrays;

public class day1005 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        int len = nums.length;
        while (k > 0) {
            if (nums[index] < 0) {
                nums[index] = -nums[index];
                k--;
                index++;
                if (k != 0 && index == len) {
                    Arrays.sort(nums);
                    index = 0;
                }
            } else {
                if (k >= 2) {
                    k = k - 2;
                } else {
                    Arrays.sort(nums);
                    index = 0;
                    nums[index] = -nums[index];
                    k--;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
        }
        return count;
    }
}

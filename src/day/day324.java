package day;

import java.util.Arrays;

/**
 * 摆动排序II
 */
public class day324 {

    /**
     * 排序 小到大-大到小交叉排列
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i+= 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}

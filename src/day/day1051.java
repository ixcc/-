package day;

import java.util.Arrays;

/**
 * 高度检查器
 */
public class day1051 {

    /**
     * 排序比较
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            arr[i] = heights[i];
        }
        Arrays.sort(heights);
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != arr[i]) {
                sum++;
            }
        }
        return sum;
    }
}

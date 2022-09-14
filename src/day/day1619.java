package day;

import java.util.Arrays;

/**
 * 删除某些元素后的平均值
 */
public class day1619 {

    /**
     * 排序 选取中间值
     * @param arr
     * @return
     */
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;
        for (int i = n / 20; i < 19*n / 20; i++) {
            count+= arr[i];
        }
        return count/(0.9*n);
    }
}

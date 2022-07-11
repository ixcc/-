package day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最小绝对差
 */
public class day1200 {

    /**
     * 排序
     * @param arr
     * @return
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int num = Integer.MAX_VALUE;
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < num) {
                arrays.clear();
                num = arr[i + 1] - arr[i];
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                arrays.add(temp);
            } else if (arr[i + 1] - arr[i] == num) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i + 1]);
                arrays.add(temp);
            }
        }
        return arrays;
    }
}

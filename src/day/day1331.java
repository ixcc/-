package day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组序号转换
 */
public class day1331 {

    public static void main(String[] args) {
        System.out.println(arrayRankTransform(new int[]{40,10,20,30}));
    }

    /**
     * 排序+哈希表
     * @param arr
     * @return
     */
    public static int[] arrayRankTransform(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        // 拷贝数组
//        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < temp.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], index);
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}

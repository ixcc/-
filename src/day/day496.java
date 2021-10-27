package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 下一个更大的值
 */
public class day496 {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums2.length;
        for (int i = 0; i < len; i++) {
            if (i == len - 1) {
                map.put(nums2[i], -1);
                break;
            }
            for (int j = i + 1; j < len; j++) {
                if (nums2[j] > nums2[i]) {
                    map.put(nums2[i],nums2[j]);
                    break;
                } else if (j == len - 1) {
                    map.put(nums2[i], -1);
                }
            }
        }
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = map.get(nums1[i]);
        }
        return arr;
    }
}

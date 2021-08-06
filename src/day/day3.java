package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串/数组
 */
public class day3 {

    /**
     * 最长无重复子数组
     * 输入：[1,2,3,1,2,3,2,2]
     * 返回值：3
     * 说明：最长子数组为[1,2,3]
     * @param arr
     * @return
     */
    public static int maxLength (int[] arr) {
        // write code here
        if (arr.length <= 1) {
            return arr.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int left = 0, right = 1;
        int count = 0;
        while (left <= right && right < arr.length) {
            if (map.containsKey(arr[right]) && map.get(arr[right])  >= left) {
                left = map.get(arr[right]) + 1;
                map.put(arr[right], right);
            } else {
                map.put(arr[right], right);
            }
            if (count < right - left) {
                count = right - left;
            }
            right++;
        }
        return count + 1;
    }

    /**
     * 无重复字符的最长子串
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 特殊情况处理
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int countLong = 1; // 变量定义
        Map<Character, Boolean> map = new HashMap<>(); // map存放已经变量过的字符
        map.put(s.charAt(0), true);
        int left = 0, right = 1;
        while (right <= s.length() - 1) {
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right))) {
                // map中包含有这个字符
                map.put(s.charAt(left), false);
                left++;
            } else {
                //  map中不包含有这个字符
                map.put(s.charAt(right), true);
                right++;
            }
            // 判断子字符串长度
            if (right - left > countLong) {
                countLong = right - left;
            }
        }
        return countLong;
    }
}

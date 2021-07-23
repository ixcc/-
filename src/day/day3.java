package day;

import java.util.HashMap;
import java.util.Map;

public class day3 {

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

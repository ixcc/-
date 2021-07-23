package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwakep"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int length = 0;
        int left = -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 存在字符更新左指针--最新重复字符位置
                left = Math.max(left,map.get(s.charAt(i)));
            }
            // 更新字符最新位置或新增字符
            map.put(s.charAt(i),i);
            // 判断最大长度比较
            length = Math.max(length,i - left);
        }
        return length;
    }
}

package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计一致字符串的数目
 */
public class day1684 {

    public int countConsistentStrings(String allowed, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < allowed.length(); i++) {
            map.put(allowed.charAt(i), 1);
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            boolean flag = true;
            for (int j = 0; j < temp.length(); j++) {
                if (!map.containsKey(temp.charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}

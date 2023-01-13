package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 重排字符形成的目标字符串
 */
public class day2287 {
    /**
     * 哈希表
     * @param s
     * @param target
     * @return
     */
    public static int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            map.put(target.charAt(i), map.getOrDefault(target.charAt(i), 0) + 1);
        }
        Map<Character, Integer> strMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                strMap.put(s.charAt(i), strMap.getOrDefault(s.charAt(i) , 0) + 1);
            }
        }
        int count = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            if (!strMap.containsKey(m.getKey())) {
                return 0;
            }
            int temp = strMap.get(m.getKey()) / m.getValue();
            if (count > temp) {
                count = temp;
            }
        }
        return count;
    }
}

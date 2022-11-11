package day;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断两个字符串是否相似
 */
public class day1704 {

    /**
     * 哈希表
     * @param s
     * @return
     */
    public boolean halvesAreAlike(String s) {
        int left = 0, right = 0;
        int len = s.length()/2;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i = 0; i < len ; i++) {
            if (set.contains(s.charAt(i))) {
                left++;
            }
            if (set.contains(s.charAt(i + len))) {
                right++;
            }
        }
        return left == right ? true : false;
    }
}

package day;

import java.util.HashSet;
import java.util.Set;

/**
 * 字符串中不同数的数目
 */
public class day1805 {

    /**
     * 双指针排除前导0
     * @param word
     * @return
     */
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        int count = 0;
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c < 58) {
                // c为数字
                int j = i;
                // 判断数字长度
                while (j < word.length() && word.charAt(j) < 58) {
                    j++;
                }
                // 排除前导0
                while (i < j && word.charAt(i) == 48) {
                    i++;
                }
                // 记录到 set
                set.add(word.substring(i, j));
                i = j;
            }
        }
        return set.size();
    }
}

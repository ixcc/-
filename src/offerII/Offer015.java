package offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串中所有变位词
 */
public class Offer015 {

    /**
     * 滑动窗口+26字母哈希表
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] arrS = new int[26];
        int[] arrP = new int[26];
        // 长度s小于p直接返回空
        if (s.length() < p.length()) {
            return list;
        }
        for (int i = 0; i < p.length(); i++) {
            arrS[s.charAt(i) - 'a']++;
            arrP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arrS, arrP)) {
            list.add(0);
        }
        for (int j = p.length(); j < s.length(); j++) {
            arrS[s.charAt(j) - 'a']++;
            arrS[s.charAt(j - p.length()) - 'a']--;
            if (Arrays.equals(arrS, arrP)) {
                list.add(j - p.length() + 1);
            }
        }
        return list;
    }
}

package day;

/**
 * 仅一次字符串交换能否字符串相等
 */
public class day1790 {

    /**
     * 一次遍历判断不等次数和交换后结果
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
        int index = 0, j = 0;
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                } else if (count == 1) {
                    index = i;
                } else if (count == 2) {
                    j = i;
                }
            }
        }
        if (count == 0 || (s1.charAt(index) == s2.charAt(j) && s1.charAt(j) == s2.charAt(index))) {
            return true;
        } else {
            return false;
        }
    }
}

package day;

/**
 * 情感丰富的文字
 */
public class day809 {

    public static int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String t : words) {
            if (expand(s, t)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 双指针
     * @param s
     * @param t
     * @return
     */
    public static boolean expand(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                return false;
            }
            char ch = s.charAt(i);
            int chari = 0;
            while (i < s.length() && s.charAt(i) == ch) {
                chari++;
                i++;
            }
            int charj = 0;
            while (j < t.length() && t.charAt(j) == ch) {
                charj++;
                j++;
            }
            if (chari < charj) {
                return false;
            }
            if (chari > charj && chari < 3) {
                return false;
            }
        }
        return i == s.length() && i == t.length();
    }
}

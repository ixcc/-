package interview;

/**
 * 字符串轮转
 */
public class interview0109 {
    public static void main(String[] args) {
        System.out.println(isFlipedString("aba", "bab"));
    }

    /**
     * 拼接 s2+s2 比较里面是否包含 s1
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        } else if (s1.equals(s2)) {
            return true;
        }
        String str = s2 + s2;
        for (int i = 0; i < s2.length(); i++) {
            if (str.charAt(i) == s1.charAt(0)) {
                int j = 1;
                while (j < s1.length()) {
                    if (str.charAt(i + j) != s1.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if (j == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}

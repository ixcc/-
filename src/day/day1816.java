package day;

/**
 * 截断句子
 */
public class day1816 {

    /**
     * stringbuffer追加
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence(String s, int k) {
        StringBuffer str = new StringBuffer();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                str.append(s.charAt(i));
            } else {
                index++;
                if (index == k) {
                    return str.toString();
                } else {
                    str.append(s.charAt(i));
                }
            }
        }
        return str.toString();
    }

    /**
     * substring
     * @param s
     * @param k
     * @return
     */
    public String truncateSentence2(String s, int k) {
        int index = 0, end = 0;
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                index++;
                if (index == k) {
                    end = i;
                    break;
                }
            }
        }
        return s.substring(0, end);
    }
}

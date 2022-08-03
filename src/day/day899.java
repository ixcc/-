package day;

import java.util.Arrays;

/**
 * 有序队列
 */
public class day899 {

    /**
     * 分k==1找最小可能 k>1 直接排序找最小
     * @param s
     * @param k
     * @return
     */
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            String smart = s;
            StringBuffer str = new StringBuffer(s);
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char temp = str.charAt(0);
                str.deleteCharAt(0);
                str.append(temp);
                if (str.toString().compareTo(smart) < 0) {
                    smart = str.toString();
                }
            }
            return smart;
        }
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}

package day;

/**
 * 生成交替二进制字符串最小操作数
 */
public class day1758 {

    /**
     * 比较0开头和1开头的操作数谁最小
     * @param s
     * @return
     */
    public int minOperations(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (i % 2 == 0) {
                if (temp == '0') {
                    count++;
                }
            } else {
                if (temp == '1') {
                    count++;
                }
            }
        }
        return Math.min(count, s.length() - count);
    }
}

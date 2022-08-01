package day;

/**
 * 生成每种字符都是奇数个的字符串
 */
public class day1374 {

    public String generateTheString(int n) {
        if (n == 1) {
            return "a";
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n - 1; i++) {
            str.append("a");
        }
        if (n%2 == 0) {
            // 偶数
            str.append("b");
        } else {
            // 奇数
            str.append("a");
        }
        return str.toString();
    }

}

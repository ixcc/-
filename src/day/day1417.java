package day;

/**
 * 重新格式化字符串
 */
public class day1417 {

    /**
     * 分类判断重组
     * @param s
     * @return
     */
    public static String reformat(String s) {
        int n = s.length();
        StringBuffer number = new StringBuffer();
        StringBuffer letter = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                number.append(s.charAt(i));
            } else {
                letter.append(s.charAt(i));
            }
        }
        StringBuffer str = new StringBuffer();
        // 不满足条件
        if (Math.abs(number.length() - letter.length()) > 1) {
            return "";
        } else if (number.length() == letter.length()) {
            for (int i = 0; i < number.length(); i++) {
                str.append(number.charAt(i));
                str.append(letter.charAt(i));
            }
        } else if (number.length() < letter.length()) {
            for (int i = 0; i < letter.length() - 1; i++) {
                str.append(letter.charAt(i));
                str.append(number.charAt(i));
            }
            str.append(letter.charAt(letter.length() - 1));
        } else if (number.length() > letter.length()) {
            for (int i = 0; i < number.length() - 1; i++) {
                str.append(number.charAt(i));
                str.append(letter.charAt(i));
            }
            str.append(number.charAt(number.length() - 1));
        }
        return str.toString();
    }
}

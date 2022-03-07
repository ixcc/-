package day;

/**
 * 十进制转7进制
 */
public class day504 {

    /**
     * 判断正负，stringBuffer拼接
     * num % 7
     * num / 7
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        StringBuffer str = new StringBuffer();
        while (num > 0) {
            str.append(num % 7);
            num = num / 7;
        }
        if (flag) {
            str.append("-");
        }
        return str.reverse().toString();
    }
}

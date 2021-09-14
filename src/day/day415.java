package day;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串相加
 */
public class day415 {

    public static void main(String[] args) {
        System.out.println(addStrings("1","99"));
    }

    public static String addStrings(String num1, String num2) {
        List<Integer> list = new ArrayList<>();
        int left = num1.length() - 1, right = num2.length() - 1;
        int add = 0; // 进位
        while (left >= 0 || right >= 0) {
            if (left >= 0) {
                add += (int)num1.charAt(left) - (int)('0');
                left-- ;
            }
            if (right >= 0) {
                add += (int)num2.charAt(right) - (int)('0');
                right-- ;
            }
            list.add(add % 10);
            add = add/10;
        }
        if (add != 0) {
            list.add(add);
        }
        StringBuilder str = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            str.append(list.get(i));
        }
        return str.toString();
    }
}

package day;

import java.util.HashMap;
import java.util.Map;

public class day13 {

    // 定义map记录数值
    Map<Character, Integer> map = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int sum = 0;
        int len = s.length() - 1;
        for (int i = len; i >= 0; i--) {
            int temp = map.get(s.charAt(i)); // 记录当前代表数字
            // 如果当前数字比后一位数值小且i不为len时则代表特殊情况--需要减去当前值
            if (i != len && map.get(s.charAt(i + 1)) > temp) {
                sum -= temp;
            } else {
                // 否则正常加上该值即可
                sum += temp;
            }
        }
        return sum;
    }
}

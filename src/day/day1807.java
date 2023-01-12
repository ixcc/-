package day;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 替换字符串中的括号内容
 */
public class day1807 {

    /**
     * 哈希表
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }
        boolean addKey = false;
        StringBuffer res = new StringBuffer();
        StringBuffer key = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                // 开始记录建
                addKey = true;
            } else if (c == ')') {
                // 结束记录健
                if (map.containsKey(key.toString())) {
                    // 哈希表有对应的键值
                    res.append(map.get(key.toString()));
                } else {
                    // 没有对应
                    res.append("?");
                }
                // 清除记录
                key.setLength(0);
                addKey = false;
            } else {
                // 字母
                if (addKey) {
                    // 在健内
                    key.append(c);
                } else {
                    // 不在健内
                    res.append(c);
                }
            }
        }
        return res.toString();
    }
}

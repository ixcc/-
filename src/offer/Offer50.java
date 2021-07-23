package offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Offer50 {

    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1) {
                return s.charAt(j);
            }
        }
        return ' ';
    }

    public char firstUniqChar2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        // 遍历第一次字符串找到所有字符出现次数或者只出现一次的索引位置
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        int index = s.length();
        // 遍历哈希表找到最先出现的且只出现一次的字符串
        for (Map.Entry<Character,Integer> m : map.entrySet()) {
            if (m.getValue() != -1 && m.getValue() < index) {
                // 找到出现索引更小的字符替换索引位置
                index = m.getValue();
            }
        }
        // 是否存在满足条件的字符，无则返回空，有则返回该索引字符
        return index == s.length() ? ' ' : s.charAt(index);
    }

    public char firstUniqChar3(String s) {
        Map<Character,Integer> map = new HashMap<>();
        Queue<por> queue = new LinkedList();
        // 遍历第一次字符串找到所有字符出现次数或者只出现一次的索引位置
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), -1);
                // 删除队列中重复元素
                while (!queue.isEmpty() && map.get(queue.peek().ch) == -1) {
                    queue.poll(); // 弹出队首重复的元素
                }
            } else {
                map.put(s.charAt(i), i);
                queue.offer(new por(s.charAt(i), i)); // 追加进队列
            }
        }
        // 队列中是否存在满足条件的字符，无则返回空，有则返回该字符
        return queue.isEmpty() ? ' ' : queue.peek().ch;
    }

    class por{
        char ch;
        int index;

        public por(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
}

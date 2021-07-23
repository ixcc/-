package offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0; // 下标移动
        Deque<Integer> deque = new ArrayDeque<>(); // 辅助栈
        // 遍历压入栈
        for (int i : pushed) {
            deque.push(i); // 压入辅助栈
            // 判断压入栈顶数据是否与退出栈顶数据相等
            while (!deque.isEmpty() && deque.peek() == popped[index]) {
                index++; // 退出栈下边往后移动--判断下一位
                deque.pop(); // 辅助栈退出相等栈顶元素
            }
        }
        // 辅助栈为空则全部元素退完--则相等返回true
        return deque.isEmpty();
    }
}

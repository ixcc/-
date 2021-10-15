package day;

/**
 * 包含Min函数的栈
 */

import java.util.Stack;

public class day155 {
    Stack<Integer> stackTotal, stackMin;

    /**
     * 利用两个栈，另外一个记录最小值
     */
    public day155() {
        stackTotal = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int val) {
        stackTotal.push(val);
        if (stackMin.isEmpty() || stackMin.peek() >= val) {
            stackMin.push(val);
        }
    }

    public void pop() {
        if (stackTotal.peek().equals(stackMin.peek())) {
            stackMin.pop();
        }
        stackTotal.pop();
    }

    public int top() {
        if (stackTotal.isEmpty()) {
            return 0;
        }
        return stackTotal.peek();
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            return 0;
        }
        return stackMin.peek();
    }
}

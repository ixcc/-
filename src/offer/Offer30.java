package offer;

import java.util.Stack;

public class Offer30 {
    Stack<Integer> A,B;

//    public MinStack() {
//        A = new Stack<Integer>(); //主栈
//        B = new Stack<Integer>(); //辅助栈记录最小值保证O(1)
//    }

    public void push(int x) {
        A.add(x); //A栈添加元素
        // B为空或者B的栈顶元素大于等于x--则添加进B栈中
        if (B.isEmpty() || B.peek() >= x) {
            B.push(x); //B栈添加元素--目前A栈种的最小元素
        }
    }

    public void pop() {
        // 判断A栈是否为空，避免抛出异常
        if (A.isEmpty()) {
           return;
        }
        if (A.peek().equals(B.peek())) {
            // A栈顶元素与B的栈顶元素相同--移除B栈顶维护的最小值
            B.pop();
        }
        A.pop(); // A栈移出栈顶元素

    }

    public int top() {
        if (A.isEmpty()) {
            return  0; // 返回A的栈顶元素值
        }
        return A.peek(); // 返回A的栈顶元素值
    }

    public int min() {
        if (B.isEmpty()) {
            return 0;
        }
       return B.peek();// 返回B的栈顶元素--因其维护的A栈目前最小值
    }
}

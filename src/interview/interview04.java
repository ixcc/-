package interview;

import java.util.Stack;

public class interview04 {

    /**
     * 2、【编程题】用递归颠倒一个栈。例如输入栈{1, 2, 3, 4, 5}， 1 在栈顶。
     * 颠倒之后的栈为{5, 4, 3, 2, 1}， 5 处在栈顶。【中等】
     */
//    public static Stack<Integer> st;
//
//    public static void stackSort(Stack<Integer> s) {
//        if (s.isEmpty()) {
//            return;
//        }
//        int temp = s.pop();
//        st.add(temp);
//        stackSort(s);
//    }
//
//    public static void main(String[] args) {
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 5; i >= 1; i--) {
//            stack.add(i);
//        }
//        stackSort(stack);
//        for (int i = 1; i <= 5; i++) {
//            System.out.println(st.pop());
//        }
//
//    }

    //递归函数一：将栈的栈底元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();    //用于恢复原位做的记录
        if(stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);       //恢复原来的顺序
            return last;
        }
    }

    //递归函数二：用于将栈逆序
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        interview04 s = new interview04();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        s.reverse(stack);
        System.out.println(stack);
    }


}

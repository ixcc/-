package day;

import java.util.LinkedList;
import java.util.Stack;

public class day1047 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates2("abbaca"));
    }

    public static String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        String str = "";
        for (Character i : stack) {
            str = str + i;
        }
        return str;
    }

    public static String removeDuplicates(String S) {
        StringBuffer str = new StringBuffer();
        int index = -1;
        for (int i = 0; i < S.length(); i++) {
            if (index >= 0  && str.charAt(index) == S.charAt(i)) {
                str.deleteCharAt(index);
                index--;
            } else {
                str.append(S.charAt(i));
                index++;
            }
        }
        return str.toString();
    }
}

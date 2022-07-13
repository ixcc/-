package day;

import java.util.Stack;

/**
 * 行星碰撞
 */
public class day735 {

    /**
     * 栈记录行星大小
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int index = 1;
        while(index < asteroids.length) {
            int temp = asteroids[index];
            while (!stack.isEmpty() && (stack.peek() > 0 && temp < 0)) {
                int top = stack.pop();
                if (Math.abs(top) > Math.abs(temp)) {
                    stack.push(top);
                    temp = 0;
                } else if (Math.abs(top) == Math.abs(temp)) {
                    temp = 0;
                }
            }
            if (temp != 0) {
                stack.push(temp);
            }
            index++;
        }
        int[] arr = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--){
            arr[i] = stack.pop();
        }
        return arr;
    }
}

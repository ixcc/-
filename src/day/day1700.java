package day;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 无法吃午餐的学生数量
 */
public class day1700 {

    /**
     * 队列模拟
     * @param students
     * @param sandwiches
     * @return
     */
    public int countStudents(int[] students, int[] sandwiches) {
        int len = students.length;
        if (len == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.offer(students[i]);
        }
        for (int i = 0; i < len; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int top = queue.poll();
                if (top == sandwiches[i]) {
                    break;
                } else {
                    queue.offer(top);
                }
            }
            if (queue.size() == size) {
                return len - i;
            }
        }
        return 0;
    }

    /**
     * 统计学生中0和1的数量
     * @param students
     * @param sandwiches
     * @return
     */
    public int countStudents2(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < students.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}

package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer59I {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] array = new int[nums.length - k + 1];
        int left = 0, right = k - 1;
        while (right <= nums.length - 1) {
            int maxNum = Integer.MIN_VALUE;
            for (int i = left; i <= right; i++) {
                if (nums[i] > maxNum) {
                    maxNum = nums[i];
                }
            }
            array[left] = maxNum;
            left ++;
            right ++;
        }
        return array;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] array = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // 定义单调队列，存储窗口中值从大到小顺序
        int index = 0; // 数组存值下标
        // 未形成窗口时
        for (int i = 0; i < k; i++) {
            // 队列不为空且当前追加的值比单调队列尾端值大时
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast(); // 单调队列删除末尾小值的元素
            }
            deque.addLast(nums[i]); // 单调队列追加进新的值
        }
        array[index++] = deque.peekFirst(); // 目标数组加入首位窗口内最大值--即队列首位的值大小
        // 形成窗口时
        for (int i = k; i < nums.length; i++) {
            // 如窗口内上一次最大值即为上次窗口左边界时--删除队首元素
            if (deque.peekFirst() == nums[i - k]) {
                deque.removeFirst(); // 首位不在队列中，删除队首元素
            }
            // 删除队列中比当前值大的值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            // 把当前值添加到队列中
            deque.addLast(nums[i]);
            // 把队列的首位值添加到数组中
            array[index++] = deque.peekFirst();
        }
        return array;
    }
}

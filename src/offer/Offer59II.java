package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Offer59II {

    // 定义双端队列和队列
    Deque<Integer> deque; // 双端队列维系队列元素递减规律
    Queue<Integer> queue; // 队列用于压入弹出队首元素

    public Offer59II() {
        deque = new LinkedList<>();
        queue = new LinkedList<>();
    }

    public int max_value() {
        // 如果双端队列不为空则检索队首元素返回
        if (!deque.isEmpty()) {
          return deque.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.offer(value); // 队列追加元素
        // 如果双端队列不为空且队尾元素小于新追加元素--则加入到队尾中
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast(); // 删除双端队列队尾小于新追加值的原数值
        }
        deque.offerLast(value); // 双端队列追加新值
    }

    public int pop_front() {
        if (!queue.isEmpty()) {
            // 如果队首元素等于栈首元素则同时弹出栈首元素
            // 这里用equals比较两个封装类，用==比较的地址会出错
            if (deque.peekFirst().equals(queue.peek())) {
                deque.pollFirst(); // 弹出队首元素
            }
            return queue.poll(); // 队列弹出队首元素
        }
        return -1;
    }
}

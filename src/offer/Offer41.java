package offer;

import java.util.*;

public class Offer41 {

    Queue<Integer> A, B;
    int n;

    public Offer41() {
            A = new PriorityQueue<>(); // 小顶堆
            B = new PriorityQueue<>(new Comparator<Integer>() { // 大顶堆
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
    }

    public void addNum(int num) {
        if (n%2 == 0) {
            // 偶数 + 1--先放B推出堆顶元素再放入A堆
            B.offer(num);
            A.offer(B.poll());
        } else {
            // 奇数 + 1--先方A推出堆顶元素再放入B
            A.offer(num);
            B.offer(A.poll());
        }
        n++;
    }

    public double findMedian() {
        if (n%2 == 0) {
            // 偶数--A\B取堆顶元素除以2
            return (A.peek() + B.peek())/2.0;
        } else {
            // 奇数--取A堆顶元素
            return A.peek();
        }
    }
}

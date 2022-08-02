package day;

/**
 * 循环队列
 */
public class day622 {

    int[] arr;
    int cap;
    int front, rear;

    /**
     * 单数组循环
     * @param k
     */
    public day622(int k) {
        cap = k + 1;
        arr = new int[cap];
        front = rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            // 队列已满
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1)% cap;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            // 队列已空
            return false;
        }
        front = (front + 1)% cap;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            // 队列已空
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            // 队列已空
            return -1;
        }
        return arr[(rear - 1 + cap)% cap];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return front == (rear + 1)% cap;
    }
}

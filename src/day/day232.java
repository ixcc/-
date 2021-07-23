package day;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class day232 {

    Deque<Integer> stackOne;
    Deque<Integer> stackTwo;

    public void MyQueue() {
        stackOne = new LinkedList<>();
        stackTwo = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackOne.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stackTwo.isEmpty()) {
           return stackTwo.pop();
        } else {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!stackTwo.isEmpty()) {
            return stackTwo.peek();
        } else {
            while (!stackOne.isEmpty()) {
                stackTwo.push(stackOne.pop());
            }
            return stackTwo.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stackOne.isEmpty() && stackTwo.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

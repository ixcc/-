package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer09 {


    public static void main(String[] args) {

    }
}

class CQueue{
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value){
        stack1.push(value);
    }

    public int deleteHead(){
        if(!stack2.isEmpty()){
           int deleteItem = stack2.pop();
           return deleteItem;
        }
        if(!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            int deleteItem = stack2.pop();
            return deleteItem;
        }else {
            return -1;
        }
    }
}


//class CQueue {
//    Deque<Integer> stack1;
//    Deque<Integer> stack2;
//
//    public CQueue() {
//        stack1 = new LinkedList<Integer>();
//        stack2 = new LinkedList<Integer>();
//    }
//
//    public void appendTail(int value) {
//        stack1.push(value);
//    }
//
//    public int deleteHead() {
//        // 如果第二个栈为空
//        if (stack2.isEmpty()) {
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//        }
//        if (stack2.isEmpty()) {
//            return -1;
//        } else {
//            int deleteItem = stack2.pop();
//            return deleteItem;
//        }
//    }
//}


package offerII;

import java.util.Stack;

/**
 * 回文链表
 */
public class Offer027 {

    /**
     * 栈
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        Stack<ListNode> stack = new Stack<>();
        if (head != null) {
            stack.push(head);
            head = head.next;
        }
        int index = 2;
        while (head != null){
            if (len%2 != 0 && index == len/2 + 1) {
                index++;
                head = head.next;
                continue;
            }
            if (index <= len/2) {
                stack.push(head);
            } else if(index > len/2){
                if (stack.pop().val != head.val) {
                    return false;
                }
            }
            head = head.next;
            index++;
        }
        return stack.size() == 0;
    }
}

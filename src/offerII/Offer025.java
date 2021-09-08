package offerII;

import java.util.Stack;

/**
 * 链表中两数相加
 */
public class Offer025 {

    /**
     * 栈存储节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stackOne = new Stack<>();
        Stack<ListNode> stackTwo = new Stack<>();
        while (l1 != null) {
            stackOne.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stackTwo.add(l2);
            l2 = l2.next;
        }
        ListNode nHead = null;
        int add = 0;
        while (!stackOne.isEmpty() || !stackTwo.isEmpty()) {
            int value = add;
            if (!stackOne.isEmpty()) {
                value += stackOne.pop().val;
            }
            if (!stackTwo.isEmpty()) {
                value += stackTwo.pop().val;
            }
            ListNode node = new ListNode(value % 10);
            node.next = nHead;
            nHead = node;
            add = value / 10;
        }
        if (add > 0){
            ListNode node = new ListNode(add);
            node.next = nHead;
            nHead = node;
        }
        return nHead;
    }
}

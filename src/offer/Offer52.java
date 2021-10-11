package offer;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 两个链表的第一个公共交点
 */
public class Offer52 {

    /**
     * 如果链表存在公共交点，双指针走完两个链表，公共部分a + b + c 即为交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB; // 定义A、B指针
        while (A != B) {
            // 如果A指针所在节点不为空则遍历链表A的下一个节点，为空则开始遍历链表B
            A = A != null ? A.next : headB;
            // 如果B指针所在节点不为空则遍历遍历B的下一个节点，为空则开始遍历链表A
            B = B != null ? B.next : headA;
        }
        return A;
    }

    /**
     * set记录节点值，遍历另一个链表找到第一个相同节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 两个栈存储节点，判断至第一个不相等的节点返回上一个节点值
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        Stack<ListNode> stackOne = new Stack<ListNode>();
        Stack<ListNode> stackTwo = new Stack<ListNode>();
        while (headA != null) {
            stackOne.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackTwo.push(headB);
            headB = headB.next;
        }
        ListNode res = null;
        while (!stackOne.isEmpty() && !stackTwo.isEmpty() && stackOne.peek() == stackTwo.peek()) {
            res = stackOne.pop();
            stackTwo.pop();
        }
        return res;
    }
}

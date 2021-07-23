package offer;

public class Offer52 {

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
}

package offerII;

/**
 * 两个链表的第一个重合点
 */
public class Offer023 {

    /**
     * 双指针
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode A = headA, B = headB;
            while (A !=  B) {
                A = A == null ? headB : A.next;
                B = B == null ? headA : B.next;
            }
            return A;
        }
    }
}

package offerII;


import java.util.HashSet;
import java.util.Set;

/**
 * 链表中环的入口节点
 */
public class Offer022 {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    /**
     * 哈希表set记录节点值
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
         Set<ListNode> set = new HashSet<ListNode>();
         while (head != null) {
             if (set.contains(head)) {
                 return head;
             } else {
                 set.add(head);
                 head = head.next;
             }
         }
         return null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
package day;

public class day83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
    public ListNode deleteDuplicates2(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode left = head;
        ListNode right = head.next;
        while (right != null) {
            if (left.val == right.val) {
                right = right.next;
            } else {
                left.next = right;
                left = right;
                right = right.next;
            }
        }
        left.next = right;
        return head;
    }
}

package offer;

public class Offer22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode low = head;
        ListNode fast = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while (fast.next != null){
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

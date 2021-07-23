package day;


public class day21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 定义空节点
        ListNode node = dummyHead;
        if (l1 == null && l2 == null) {
            return node;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                node.next = l2;
                return node;
            } else if (l2 == null) {
                node.next = l1;
                return node;
            } else if (l1.val <= l2.val){
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else{
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        return node;
    }

    // 递归方式
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}


class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

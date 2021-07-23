package offer;

public class Offer25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode  mergeNode = new ListNode(0), cur = mergeNode;
        while (l1 != null || l2 != null){
            if(l1 == null){
                cur.next = l2;
                return mergeNode.next;
            }else if(l2 == null){
                cur.next = l1;
                return mergeNode.next;
            }
            if(l1.val<=l2.val){
                cur.next= l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return mergeNode.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return l1 == null ? l2 :l1;
        }
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists2(l1,l2.next);
            return l2;
        }
    }
}

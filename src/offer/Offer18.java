package offer;



public class Offer18 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode deleteNode(ListNode head, int val) {
        //头结点与删除值相等则返回head的next即可
        if(head.val==val){
            return head.next;
        }
        //遍历链表
        ListNode node = head;
        //指向链表前一个节点
        ListNode preNode = node;
        while (node != null){
            if(node.val == val){
                //删除目标节点，指向下下个节点
                preNode.next = node.next;
                break;
            }
            preNode = node;
            node = node.next;
        }
        return head;
    }
}

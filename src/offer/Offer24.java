package offer;

public class Offer24 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null,temp = null;//定义新链表和临时链表
        while (head != null){
            temp = head.next;//链表某节点后暂存在临时链表--暂存某节点后的链表数据
            head.next = pre;//某节点后链表更改为pre--该节点后节点替换为新链表
            pre = head;//新链表加上某节点为头节点--新链表加上新的头节点和原链表数据
            head = temp;//目标链表替换为暂存链表--继续迭代后一个节点
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode ret = reverseList2(head.next);
        head.next.next = head;//让某节点的下一个节点的指针指向该节点
        head.next = null;//该节点的指向为Null
        return ret;
    }

}



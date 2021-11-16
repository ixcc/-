package day;

/**
 * 反转链表
 */
public class day206 {

    /**
     * 定义新链表和空链表 迭代遍历旧链表
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, temp = null; // 定义新的链表和临时链表
        while (head != null) {
            temp = head.next; // 暂存下一个链表节点
            head.next = pre; // 更改当前节点指向
            pre = head; // 新链表节点移动
            head = temp; // 遍历旧链表的下一个节点
        }
        return pre;
    }
}

package day;

/**
 * 不传头结点情况下删除链表某节点
 */
public class day237 {

    /**
     * 替换掉该节点值为下一个节点值，下一个节点链接更改为下下个节点
     * 用下一个节点覆盖当前节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        ListNode nodeNext = node.next;
        node.val = nodeNext.val;
        node.next = nodeNext.next;
    }
}

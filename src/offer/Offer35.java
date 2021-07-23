package offer;

import java.util.HashMap;
import java.util.Map;

public class Offer35 {

    public Node35 copyRandomList(Node35 head) {
        if (head == null) {
            return null;
        }
        Node35 cur = head; // 复制一个链表用于遍历
        Map<Node35,Node35> map = new HashMap<>(); // 第一个旧链表，第二个为新链表
        while (cur != null) {
            Node35 curNew = new Node35(cur.val);// 复制新节点
            map.put(cur,curNew); // key为旧节点，value为新节点
            cur = cur.next; // 遍历链表下一个节点
        }
        cur = head; // 又从头节点遍历
        while (cur != null) {
            map.get(cur).next = map.get(cur.next); // 新节点的next值赋值 -->旧节点key值中cur.next
            map.get(cur).random = map.get(cur.random); // 新节点的random值赋值 -->旧节点key值中cur.random
            cur = cur.next; // 节点遍历
        }
        return map.get(head);
    }
}

class Node35 {
    int val;
    Node35 next;
    Node35 random;

    public Node35(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

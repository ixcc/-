package day;

public class day2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0); // 定义空节点头
        ListNode nodeTwo = dummyHead; // 定义存储两数合的链表
        int carry = 0; // 定义进位值
        while (l1 != null || l2 != null) {
            ListNode node = new ListNode(0); // 新节点
            int value = 0; // 新节点的值
            if (l1 != null && l2 != null) {
                // 都不为空时两数计算
                value = (l1.val + l2.val + carry)%10;
                carry = (l1.val + l2.val + carry)/10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 == null) {
                // l2节点为空时，新节点和为l1节点+进位
                value = (l1.val + carry)%10;
                carry = (l1.val + carry)/10;
                l1 = l1.next;
            } else if (l1 == null) {
                // l1节点为空时，新节点和为l2节点+进位
                value = (l2.val + carry)%10;
                carry = (l2.val + carry)/10;
                l2 = l2.next;
            }
            // 两数合链表追加继续
            node.val = value;
            nodeTwo.next = node;
            nodeTwo = node;

        }
        // 判断最后进位是否为0--是否要追加新节点
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            nodeTwo.next = node;
        }
        // 返回目标节点
        return dummyHead.next;
    }
}

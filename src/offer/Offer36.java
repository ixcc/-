package offer;

public class Offer36 {

    Node pre, head; // 定义全局变量前驱节点和头结点，初始值为空
    public Node treeToDoublyList(Node root) {
        // 边界值处理--root二叉树为空返回Null
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre; // 双向链表-- 最后头结点的left指向pre
        pre.right = head; // 双向链表-- 最后尾结点(最后为pre)的right指向head
        return head;
    }

    public void dfs(Node cur) {
        // 递归至边界
        if (cur == null) {
           return;
        }
        // 中序遍历--先左节点
        dfs(cur.left);
        // 中序遍历处理该节点逻辑
        // 判断前驱结点是否为空
        if (pre != null) {
            pre.right = cur; // 不为空--前驱结点的右链表顺序为当前节点
        } else {
            head = cur; // 为空--则头结点为当前节点
        }
        cur.left = pre; // 当前节点的前驱节点为pre
        pre = cur; // 更改前驱节点为当前节点
        dfs(cur.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

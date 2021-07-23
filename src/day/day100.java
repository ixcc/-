package day;

import java.util.LinkedList;
import java.util.Queue;

public class day100 {

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            // 两个都为空则返回true
            return true;
        } else if (p == null || q == null) {
            // 其中一个为空则返回false
            return false;
        } else if(p.val != q.val) {
            // 两个节点值不相等返回false
            return false;
        } else {
            // 递归遍历节点的左右节点
            return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 定义队列存放节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            // 取出p、q二叉树的两个节点
            TreeNode nodeP = queue.poll();
            TreeNode nodeQ = queue.poll();
            // 都为空则继续判读下一下
            if (nodeP == null && nodeQ == null) {
                continue;
            }
            // 为false的可能直接返回
            if (nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) {
                return false;
            }
            // 追加左节点
            queue.add(nodeP.left);
            queue.add(nodeQ.left);
            // 追加右节点
            queue.add(nodeP.right);
            queue.add(nodeQ.right);
        }
        return true;
    }
}

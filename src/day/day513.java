package day;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 寻找二叉树最底层最左边的节点值
 */
public class day513 {

    /**
     * bfs
     * @param root
     * @return
     */
    public int findBottomLeftValue(TreeNode root) {
        int val = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            val = node.val;
        }
        return val;
    }
}

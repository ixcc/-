package day;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层数最深叶子节点数之和
 */
public class day1302 {

    /**
     * 层序遍历
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count = 0;
            for (int i = size; i > 0; i--) {
                TreeNode node =  queue.poll();
                count += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return count;
    }
}

package offer;

import java.util.LinkedList;
import java.util.Queue;

public class Offer55I {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // BFS层序遍历--利用队列
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>(); // 定义队列
        // 如果root不为空则将根节点加入到队列中
        if (root != null) {
            queue.add(root);
        }
        int res = 0; // 统计层数
        while (!queue.isEmpty()) {
            res++; // 层数统计加一
            int n = queue.size(); // 该层节点数量,防止遍历节点时动态变化
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll(); // 取出队首节点
                // 该节点的左节点不为空则加入队列中
                if (node.left != null) {
                    queue.add(node.left);
                }
                // 该节点的右节点不为空则加入到队列中
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

}

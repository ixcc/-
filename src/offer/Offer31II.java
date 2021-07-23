package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Offer31II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        // root不为空队列追加root
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            // 每层定义新的List存放节点
            List<Integer> tempArr = new ArrayList<>();
            // deque.size()作为循环初始值--即为每层节点个数，且后徐追加影响size但循环次数不变
            for (int i = deque.size(); i > 0; i--) {
                // 弹出队列节点放入层集合tempArr中
                TreeNode node = deque.poll();
                tempArr.add(node.val);
                // 判断是否节点有下一层左右节点
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            // 层节点集合放入多层节点集合中
            array.add(tempArr);
        }
        return array;
    }
}

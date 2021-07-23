package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32I {

    public int[] levelOrder(TreeNode root) {
        // root为空判断
        if (root == null) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>(); // 定义存放节点集合
        Queue<TreeNode> queue = new LinkedList<>(); // 定义存放节点队列
        queue.offer(root); // 加入初始根节点
        while (!queue.isEmpty()) { // 队列不为空则进入while循环
            TreeNode node = queue.poll(); // 取出队列头节点元素
            list.add(node.val); // 节点追击进集合
            // 该节点左右子节点是否为空--不为空则追加进队列元素中
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        // 节点集合转为数组
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

//    public List<Integer> dfsTree(TreeNode root, List array){
//        if (root == null) {
//            return array;
//        }
//        array.add(root.val);
//        array.add(root.left);
//        return array;
//    }
}

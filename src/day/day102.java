package day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = len; i > 0; i--) {
                TreeNode node = queue.poll();
                arr.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            array.add(arr);
        }
        return array;
    }
}

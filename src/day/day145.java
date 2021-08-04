package day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class day145 {

    /**
     * 迭代方式
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(0, node.val); // 追加到列表头部
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return list;
    }
}

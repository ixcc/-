package day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 */
public class day144 {

    /**
     * 迭代法
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>(); // 辅助栈存放二叉树节点
        if (root != null) {
            stack.add(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            // 使用辅助栈，所以先右子树
            if (node.right != null) {
                stack.add(node.right);
            }
            // 再追加左子树
            if (node.left != null) {
                stack.add(node.left);
            }

        }
        return list;
    }
}

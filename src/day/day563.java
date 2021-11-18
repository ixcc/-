package day;

/**
 * 求二叉树的坡度
 */
public class day563 {

    public int count;

    /**
     * dfs深度遍历
     * @param root
     * @return
     */
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        count = 0;
        dfs(root);
        return count;
    }

    /**
     * 求左子树和右子树的差值，返回左子树、右子树、根节点之和
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        count += Math.abs(left - right);
        return left + right + root.val;
    }
}

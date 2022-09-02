package day;

/**
 * 最长同值路径
 */
public class day687 {

    int res;

    /**
     * dfs
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left), right = dfs(root.right);
        int leftNew = 0, rightNew = 0;
        if (root.left != null && root.val == root.left.val) {
            leftNew = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            rightNew = right + 1;
        }
        res = Math.max(res, rightNew + leftNew);
        return Math.max(rightNew, leftNew);
    }
}

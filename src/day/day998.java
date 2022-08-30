package day;

/**
 * 最大二叉树
 */
public class day998 {
    /**
     * 遍历右节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode parent = null;
        TreeNode cur = root;
        while(cur != null) {
            if (cur.val < val) {
                if (parent == null) {
                    // 根节点
                    return new TreeNode(val, root, null);
                }
                TreeNode node = new TreeNode(val, cur, null);
                parent.right = node;
                return root;
            } else {
                // 遍历右节点
                parent = cur;
                cur = cur.right;
            }
        }
        parent.right = new TreeNode(val);
        return root;
    }
}

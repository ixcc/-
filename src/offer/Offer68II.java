package offer;

public class Offer68II {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点为空或等于p或者q时--即最近祖先一定为root，返回root
        if (root == null || root == p || root == q) {
            return root;
        }
        // 后续遍历二叉树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 如果左子树没有找到等于p或者q的节点--返回右子树即两个目标节点都在树的右侧
        if (left == null) {
            return right;
        }
        // 如果左子树不为空，右子树为空即没有找到等于p或者q的节点--返回左子树即两个目标节点都在树的左侧
        if (right == null) {
            return left;
        }
        // 左子树和右子树都不为空则目标节点遍历在root的左右两侧--返回当前节点root为最深公共节点
        return root;
    }
}

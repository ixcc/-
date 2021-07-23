package offer;

public class Offer54 {

    int num = 0;
    int res = 0;
    public int kthLargest(TreeNode root, int k) {
        num = k;
        helper(root);
        return res;
    }

    public void helper(TreeNode root) {
        // 第K大的元素，所以遍历从右根左顺序
        if (root.right != null && num > 0) {
            helper(root.right);
        }
        // 目标值逐渐接近
        num--;
        if (num == 0) {
            res = root.val;
            return;
        }
        if (root.left != null && num > 0) {
            helper(root.left);
        }
    }
}

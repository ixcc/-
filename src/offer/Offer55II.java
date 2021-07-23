package offer;

public class Offer55II {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depthTree(root.left) - depthTree(root.right)) == 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public int depthTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(depthTree(root.left),depthTree(root.right)) + 1;
    }
}

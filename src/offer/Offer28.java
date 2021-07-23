package offer;

public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
           return true;
        }
        return dfsTree(root.left,root.right);
    }

    public boolean dfsTree(TreeNode rootLeft,TreeNode rootRight){
        if(rootLeft == null && rootRight == null){
            return true;
        }
        if((rootLeft == null || rootRight == null) || (rootLeft.val != rootRight.val)){
            return false;
        }
        return dfsTree(rootLeft.left,rootRight.right) && dfsTree(rootLeft.right,rootRight.left);
    }
}

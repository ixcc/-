package offer;


public class Offer26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //边界处理，A、B为空则返回false
        if(A == null || B == null){
            return false;
        }
        // a.b完全一致
        // a,b左子树相同
        // a,b右子树相同
        return dfsTree(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }

    public boolean dfsTree(TreeNode A,TreeNode B){
        // 已经判断完B所以节点--为true
        if(B == null){
            return true;
        }
        // 未判断完B但A已经遍历结束--为false
        if(A == null){
            return false;
        }
        //A、B节点值不相等
        if(A.val == B.val){
            return false;
        }
        //遍历左节点是否一致且右节点是否一致
        return dfsTree(A.left,B.left) && dfsTree(A.right,B.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

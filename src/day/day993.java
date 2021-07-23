package day;


public class day993 {

    int k1, k2; // 两个目标节点深度
    TreeNode node1, node2; // 两个目标节点的父节点

    public boolean isCousins(TreeNode root, int x, int y) {
        dfsTree(root, 0, null, x, y);
        return node1 != node2 && k1 == k2;
    }

    // 二叉树root、深度值k、父节点parent、目标节点x、y
    public void dfsTree(TreeNode root, int k, TreeNode parent, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            // 当前节点等于目标节点x--记录该节点的父节点和深度
            node1 = parent;
            k1 = k;
        } else if (root.val == y) {
            // 当前节点等于目标节点y--记录该节点的父节点和深度
            node2 = parent;
            k2 = k;
        } else{
            // 接续遍历
            dfsTree(root.left, k + 1, root, x, y);
            dfsTree(root.right, k + 1, root, x, y);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

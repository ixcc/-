package day;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 */
public class day236 {

    Map<Integer, TreeNode> map = new HashMap<>(); // 存放所有节点的父节点
    Set<Integer> set = new HashSet<>(); // 记录某目标节点经过的所有节点值
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        // 记录P节点经过的所有节点值
        while (p != null) {
            set.add(p.val);
            p = map.get(p.val);
        }
        // 找到q节点经过的节点值最先重复部分
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = map.get(q.val);
        }
        return root;
    }

    /**
     * 递归遍历找到所有节点的对应父节点
     * @param root
     */
    public void dfs(TreeNode root){
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }
}

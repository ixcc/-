package offer;

import java.util.*;

public class Offer34 {

    // 定义全局List存储二维数组
    private List<List<Integer>> array = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>(); // 定义合理路径集合
        sumDFS(root,sum,0,list); // dfs
        return array;
    }

    public void sumDFS(TreeNode root, int sum, int temp, List<Integer> list) {
        // 节点为空边界限制
        if (root == null) {
            return ;
        }
        temp += root.val; // 目前所以子节点的和
        list.add(root.val); // 追加进节点路径集合
        // 子节点路径和与目标值相等且左右子节点为空--避免负数节点情况
        if (temp == sum && root.left == null && root.right == null) {
            array.add(list);
        }
        // 递归左右子节点
        if (root.left != null) {
            sumDFS(root.left, sum, temp, list);
        }
        if (root.right != null) {
            sumDFS(root.right, sum, temp, list);
        }
        // 回溯退回节点值
        list.remove(list.size()-1);
    }
}

package offer;

import sun.invoke.empty.Empty;

import java.util.Stack;

public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left; //暂存二叉树做节点
        root.left = mirrorTree(root.right);//左节点更改为右节点的值
        root.right = mirrorTree(temp);//右节点更改为之前暂存左节点的值
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>(); //新建栈
        stack.add(root);//将root节点放入栈
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();//栈弹出一个节点
            //将节点不为空的左右节点放入栈
            if(node.left != null){
                stack.add(node.left);
            }
            if(node.right != null){
                stack.add(node.right);
            }
            //暂存左节点--交换左右节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

}

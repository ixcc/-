package offer;

import java.util.*;

/**
 * 从上到下打印二叉树
 */
public class Offer31III {

    public static void main(String[] args) {

        System.out.println();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
           deque.offer(root);
        }
        boolean flag = false; // 从左至右
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>(); // 每层节点存放集合
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll(); // 取出节点
                list.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            // 偶数行层数节点翻转加入节点集合
            if (flag) {
                Collections.reverse(list);
            }
            array.add(list);
            flag = !flag;
        }
        return array;
    }

    /**
     * 双端队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> array = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>(); // 双端队列每层节点存放集合
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                if (array.size() % 2 == 0) {
                    list.addLast(node.val); // 偶数层--放队尾
                } else {
                    list.addFirst(node.val); // 奇数层--放队头
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            array.add(list);
        }
        return array;
    }

    /**
     * 两个栈记录从左到右和从右到左的节点
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return array;
        }
        Stack<TreeNode> stackLeft = new Stack<TreeNode>();
        Stack<TreeNode> stackRight = new Stack<TreeNode>();
        stackLeft.add(pRoot);
        while (!stackLeft.isEmpty() || !stackRight.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            if (!stackLeft.isEmpty()) {
                while (!stackLeft.isEmpty()) {
                    TreeNode node = stackLeft.pop();
                    arr.add(node.val);
                    if (node.left != null) {
                        stackRight.add(node.left);
                    }
                    if (node.right != null) {
                        stackRight.add(node.right);
                    }
                }
            } else {
                while (!stackRight.isEmpty()) {
                    TreeNode node = stackRight.pop();
                    arr.add(node.val);
                    if (node.right != null) {
                        stackLeft.add(node.right);
                    }
                    if (node.left != null) {
                        stackLeft.add(node.left);
                    }
                }
            }
            array.add(arr);
        }
        return array;
    }
}

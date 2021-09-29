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

    /**
     * BFS里是每次只取一个，而我们这里先得到队列长度size，这个size就是这一层的节点个数，然后通过for循环去poll出这size个节点，这里和按行取值二叉树返回ArrayList<ArrayList<Integer>>这种题型的解法一样，之字形取值的核心思路就是通过两个方法：
     * list.add(T): 按照索引顺序从小到大依次添加
     * list.add(index, T): 将元素插入index位置，index索引后的元素依次后移,这就完成了每一行元素的倒序，或者使用Collection.reverse()方法倒序也可以
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        LinkedList<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean rev = true;
        q.add(pRoot);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node == null){continue;}
                if(rev){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                q.offer(node.left);
                q.offer(node.right);
            }
            if(list.size()!=0){res.add(list);}
            rev=!rev;
        }
        return res;
    }
}

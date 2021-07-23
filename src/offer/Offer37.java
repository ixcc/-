package offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 边界值处理
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pop(); // 队列弹出节点
            if (node != null) {
                res.append(node.val + ","); // 不为空则追加节点值进字符串并加上,
                // 添加节点的左右子节点进队列
                deque.offer(node.left);
                deque.offer(node.right);
            } else {
                // 为空则添加null + ,
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length()-1); // 删除最后多余的,
        return res.append("]").toString(); // 添加饭括弧进字符串，转为string
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 边界值处理--空字符串返回空二叉树
        if (data.equals("[]")) {
            return null;
        }
        // 截取[]以内的字符串以,为分隔符将其转换为String数组
        String[] vals = data.substring(1,data.length()-1).split(",");
        // 创建根节点 -- 为string数组的首位值转int
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Deque<TreeNode> deque = new LinkedList(); // 创建节点队列
        deque.offer(root); // 放入根节点
        int i = 1; // 遍历数组
        while (!deque.isEmpty()){
            TreeNode node = deque.pop(); // 队列弹出节点
            // 数组下标不为空
            if (!vals[i].equals("null")) {
                // 添加二叉树左节点
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                // 队列新加节点
                deque.offer(node.left);
            }
            i++; // 数组下标加一
            // 数组下标不为空
            if (!vals[i].equals("null")) {
                // 添加二叉树右节点
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                // 队列新加节点
                deque.offer(node.right);
            }
            i++; // 数组下标加一
        }
        return root;
    }
}

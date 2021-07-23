package offer;

import java.util.Arrays;

public class Offer07 {public TreeNode buildTree(int[] preorder, int[] inorder) {
    int len = preorder.length;
    if (len == 0) {
        return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    int index = 0;
    for (int i = 0; i < preorder.length; i++) {
        if (preorder[0] == inorder[i]) {
            index = i;
            break;
        }
    }
    root.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1), Arrays.copyOfRange(inorder, 0, index + 1));
    root.right = buildTree(Arrays.copyOfRange(preorder, index + 1, len), Arrays.copyOfRange(inorder, index + 1, len));

    return root;
}


}

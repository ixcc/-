package offer;

public class Offer33 {

    public boolean verifyPostorder(int[] postorder) {
        return isPostorder(postorder, 0 , postorder.length-1);
    }

    public boolean isPostorder(int[] postorder, int beginIndex, int endIndex){
        // 树区间范围为1则所有元素判断完毕--返回true
        if (beginIndex >= endIndex) {
            return true;
        }
        // 满足左右子树条件位置判断坐标点--point
        int point = beginIndex;
        // 满足左子树条件--所以左子数值小于根节点
        while (postorder[point] < postorder[endIndex]) {
            point++;
        }
        // 左右子树分界线位置--right
        int right = point;
        // 满足右子树条件--所以右子数值大于根节点
        while (postorder[point] > postorder[endIndex]) {
            point++;
        }
        // 坐标点最后与根节点位置相同 & 所以左子树同样满足条件 & 所以右子树满足条件
        return point == endIndex && isPostorder(postorder, beginIndex, right-1) && isPostorder(postorder, right, endIndex-1);
    }
}

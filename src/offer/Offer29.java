package offer;

public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        // 边界值判断
        if(matrix.length == 0){
            return new int[]{};
        }
        int lenX = matrix[0].length;
        int lenY = matrix.length;
        int[] array = new int[lenX*lenY];
        int count = 0; //数组下标
        int left = 0, right = lenX-1, top = 0, bottom = lenY-1; // 遍历的边界
        while (true){
            // 从左往右循环
            for (int i = left; i <= right ; i++) {
                array[count] = matrix[top][i];
                count++;
            }
            top++; // 上边界加一
            if (top > bottom) { // 判断上边界是否超过下边界
               break;
            }
            // 从上往下循环
            for (int i = top; i <= bottom; i++) {
                array[count] = matrix[i][right];
                count++;
            }
            right--; //右边界减一
            if (right < left) { // 判断右边界是否超过左边界
                break;
            }
            // 从右往左循环
            for (int i = right; i >=  left; i--) {
                array[count] = matrix[bottom][i];
                count++;
            }
            bottom--; //下边界减一
            if (bottom < top) {
                break;
            }
            // 从下往上循环
            for (int i = bottom; i >= top; i--){
                array[count] = matrix[i][left];
                count++;
            }
            left++; //左边界加一
            if (left > right) {
                break;
            }
        }
        return array;
    }
}

package offer;

public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        int i = m, j = 0;
        while (i >=0 && j <= n) {
            // 匹配的值
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                i--;
            } else if (matrix[i][j] < target) {
                j++;
            }

        }
        return false;
    }
}

package offerII;

/**
 * 二维数组的和
 */
public class Offer013 {

    int[][] sum;

    /**
     * 二维数组的前缀和
     * @param matrix
     */
    public Offer013(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 上半边矩形 + 左半边矩形 - 左上角矩形 + 自己
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] -sum[i][j] + matrix[i][j];
                }
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 完整矩形 - 上半边矩形 - 左半边矩形 + 左上角矩形
        int n = sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
        return n;
    }

}

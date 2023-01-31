package day;

/**
 * 判断一个矩阵是否为对称矩阵
 */
public class day2319 {

    /**
     * 判断 i==j 或 i == n - 1 - j 的对角线和其他值
     * @param grid
     * @return
     */
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i == n - 1 - j) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

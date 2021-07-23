package offer;

public class Offer47 {

    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               // 跳过坐标[0,0]
               if (i == 0 && j == 0) {
                   continue;
               }
               // 分三类情况
               if (i == 0) {
                   // 第一行数据量
                   grid[i][j] += grid[i][j-1]; // 加上前一位数据
               } else if (j == 0) {
                   // 第一列的数据
                   grid[i][j] += grid[i-1][j]; // 加上同列上一位数据
               } else {
                   // 其他数据遵循判断左边和上边数据量比较谁大与谁相加
                   grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
               }
           }
        }
        return grid[m-1][n-1];
    }

}

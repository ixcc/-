package day;

/**
 * 奇数值单元格的数目
 */
public class day1252 {

    /**
     * 模拟
     * @param m
     * @param n
     * @param indices
     * @return
     */
    public int oddCells(int m, int n, int[][] indices) {
        int[][] arr = new int[m][n];
        for (int k = 0; k < indices.length; k++) {
            newCells(indices[k][0], indices[k][1], arr);
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j]%2 != 0) {
                    count++;
                }
            }
        }
        return count;

    }

    public int[][] newCells(int m, int n, int[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            arr[m][i] += 1;
        }
        for (int j = 0; j < arr.length; j++) {
            arr[j][n] += 1;
        }
        return arr;
    }
}

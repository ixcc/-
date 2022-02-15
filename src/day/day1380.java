package day;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩阵中的幸运数
 */
public class day1380 {

    /**
     * 两个数组模拟行列满足最大最小的值，比较数组重复则满足条件
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length; // 行
        int n = matrix[0].length; // 列
        int[] hangMin = new int[m]; // 行最小
        int[] lieMax = new int[n];  // 列最大
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < temp) {
                    temp = matrix[i][j];
                }
                if (i == 0) {
                    lieMax[j] = matrix[i][j];
                } else {
                    if (matrix[i][j] > lieMax[j]) {
                        lieMax[j] = matrix[i][j];
                    }
                }

            }
            hangMin[i] = temp;
        }
        // 比较两个数组有没有相同值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (hangMin[i] == lieMax[j]) {
                    list.add(hangMin[i]);
                }
            }
        }
        return list;
    }
}

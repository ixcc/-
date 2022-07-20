package day;

import java.util.ArrayList;
import java.util.List;

/**
 * 二维网格迁移
 */
public class day1260 {

    /**
     *
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m*n];
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index] = grid[i][j];
                index++;
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        int position = arr.length - k%(m*n);
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (position == arr.length ) {
                    position = 0;
                    temp.add(arr[position]);
                } else {
                    temp.add(arr[position]);
                }
                position++;
            }
            list.add(temp);
        }
        return list;
    }
}

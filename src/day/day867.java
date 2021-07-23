package day;

public class day867 {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
//            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                array[i][j] = matrix[j][i];
//                temp[j] = matrix[j][i];
            }
//            array[i] = temp;
        }
        return array;
    }
}

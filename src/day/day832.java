package day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class day832 {
    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        int m = A.length; // 题目说明二维数组等长
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m/2; j++) {
                // 前后替换再翻转
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
                if (A[i][m-j-1] == 0) {
                    A[i][m-j-1] = 1;
                } else {
                    A[i][m-j-1] = 0;
                }
                int temp = A[i][j];
                A[i][j] = A[i][m-j-1];
                A[i][m-j-1] = temp;
            }
            // 奇数行数值翻转即可
            if (m%2 != 0) {
                if (A[i][m/2] == 0) {
                    A[i][m/2] = 1;
                } else {
                    A[i][m/2] = 0;
                }
            }
        }
        return A;
    }

    public static int changeNum (int num) {
        if (num == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}

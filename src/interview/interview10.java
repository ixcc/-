package interview;

/**
 * 合并两个排序数组
 */
public class interview10 {

    // 逆向双指针排序合并
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            if (i < 0 || (j >= 0 && A[i] <= B[j])) {
                A[index] = B[j];
                j--;
            } else if (j < 0 || (i >= 0 && A[i] > B[j])) {
                A[index] = A[i];
                i--;
            }
            index--;
        }
    }
}

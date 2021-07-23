package day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class day888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < A.length; i++) {
            sumA += A[i];
        }
        for (int j = 0; j < B.length; j++) {
            sumB += B[j];
        }
        int half = (sumA + sumB)/2;
        int[] array = new int[2];
        int indexA = 0;
        while (true) {
            int temp = A[indexA];
            int searchB = half - (sumA - temp);
            for (int i = 0 ;i < B.length; i++) {
                if ((B[i] == searchB) && (sumB - B[i] + temp == half)) {
                    array[0] = temp;
                    array[1] = B[i];
                    return array;
                }
            }
            indexA++;
        }
    }

    public int[] fairCandySwap2(int[] A, int[] B){
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta;
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;

    }
}

package day;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day1769 {

    public static void main(String[] args) {
        System.out.println(minOperations("110"));
    }

    public static int[] minOperations(String boxes) {
        Set<Integer> set = new HashSet<>();
        int[] array = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                set.add(i);
            }
        }
        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j: set) {
                if (boxes.charAt(i) == '1' && i == j) {
                    continue;
                }
                temp += Math.abs(j - i);
            }
            array[i] = temp;
        }
        return array;
    }
}

package interview;

import java.util.Arrays;

public class interview03 {
    public static void main(String[] args) {
        ArrayTotal(new int[]{1,2,3,4,}, new int[]{3,2,1});
    }

    // 整形数组关系判断[1,2,3,4][1,2,3]
    public static void ArrayTotal(int[] arrOne, int[] arrTwo) {
        // 数组排序
        Arrays.sort(arrOne);
        Arrays.sort(arrTwo);
        int lenOne = arrOne.length;
        int lenTwo = arrTwo.length;
        // 判断小数组
        int index = 0;
        int maxLen = 0;
        if (lenOne > lenTwo) {
            maxLen = lenTwo;
        } else {
            maxLen = lenOne;
        }
        // 判断数组数值是否一致
        while (index < maxLen) {
            if (arrOne[index] != arrTwo[index]) {
                System.out.println("没有从属关系");
                return;
            }
            index++;
        }
        // 结果判断
        if (arrOne == arrTwo) {
            System.out.println("两数组相等");
        } else if (maxLen == lenOne) {
            System.out.println("数组1是数组2的从属");
        } else {
            System.out.println("数组2是数组1的从属");
        }
    }
}

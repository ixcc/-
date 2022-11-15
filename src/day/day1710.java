package day;

import java.util.Arrays;

/**
 *卡车上的最大单位数
 */
public class day1710 {

    /**
     * 先排序，再贪心
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 排序数组
        Arrays.sort(boxTypes, (a, b) -> (b[1] - a[1]));
//        for (int i = 0; i < boxTypes.length; i++) {
//            for (int j = i; j < boxTypes.length; j++) {
//                if (boxTypes[i][1] < boxTypes[j][1]) {
//                    int[] temp = boxTypes[i];
//                    boxTypes[i] = boxTypes[j];
//                    boxTypes[j] = temp;
//                }
//            }
//        }
        int count = 0;
        int num = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] + num <= truckSize) {
                count += boxTypes[i][0] * boxTypes[i][1];
                num += boxTypes[i][0];
            } else {
                count += (truckSize - num) * boxTypes[i][1];
                return count;
            }
        }
        return count;
    }
}

package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 盒子中小球的最大数量
 */
public class day1742 {

    /**
     * 哈希表
     * @param lowLimit
     * @param highLimit
     * @return
     */
    public static int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int temp = countSum(i);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
            if (max < map.get(temp)) {
                max = map.get(temp);
            }
        }
        return max;
    }

    /**
     * 计算小球对应盒子，各位数相加
     * @param index
     * @return
     */
    public static int countSum(int index) {
        int temp = 0;
        while (index >= 10) {
            temp += index % 10; // 末位数
            index = index / 10;
        }
        temp += index;
        return temp;
    }
}

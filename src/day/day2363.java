package day;

import java.util.*;

/**
 * 合并相似的物品
 */
public class day2363 {

    /**
     * 哈希表
     * @param items1
     * @param items2
     * @return
     */
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < items1.length; i++) {
            map.put(items1[i][0], items1[i][1]);
        }
        for (int j = 0; j < items2.length; j++) {
            if (map.containsKey(items2[j][0])) {
                map.put(items2[j][0], map.get(items2[j][0]) + items2[j][1]);
            } else {
                map.put(items2[j][0], items2[j][1]);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            result.add(list);
        }
        result.sort(Comparator.comparingInt(o -> o.get(0)));
        return result;
    }
}

package day;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户分组
 */
public class day1282 {

    /**
     * 归纳值相等的数组下标
     * @param groupSizes
     * @return
     */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (groupSizes[i] == 0) {
                continue;
            }
            int index = groupSizes[i];
            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            groupSizes[i] = 0;
            for (int j = i; j < groupSizes.length & temp.size() < index; j++) {
                if (groupSizes[j] == 0) {
                    continue;
                }
                if (groupSizes[j] == index) {
                    temp.add(j);
                    groupSizes[j] = 0;
                }
            }
            list.add(temp);
        }
        return list;
    }
}

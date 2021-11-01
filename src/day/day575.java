package day;

import java.util.HashSet;
import java.util.Set;

/**
 * 分糖果
 */
public class day575 {
    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1,1,2,2,3,3}));
    }

    /**
     * set存放糖果类型数目，最多一半或set的size两种情况
     * @param candyType
     * @return
     */
    public static int distributeCandies(int[] candyType) {
        int len = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            if (!set.contains(candyType[i])) {
                set.add(candyType[i]);
            }
        }
        if (set.size() >= len / 2) {
            return len/2;
        } else {
            return set.size();
        }
    }
}

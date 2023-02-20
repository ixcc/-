package day;

import java.util.HashMap;
import java.util.Map;

/**
 * 最好的扑克手牌
 */
public class day2347 {

    /**
     * 哈希表+计数
     * @param ranks
     * @param suits
     * @return
     */
    public String bestHand(int[] ranks, char[] suits) {
        char temp = suits[0];
        for (int i = 1; i < 5; i++) {
            if (suits[i] != temp) {
                break;
            }
            if (i == 4) {
                return "Flush";
            }
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1 );
            if (map.get(ranks[i]) == 3) {
                return "Three of a Kind";
            }
        }
        if (map.size() <= 4) {
            return "Pair";
        }
        return "High Card";
    }
}

package day;

/**
 * 猴子吃香蕉
 */
public class day875 {
    /**
     * 二分法
     * 向上取整写法 （s + k - 1）/ k
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int hight = 0;
        for (int pile : piles) {
            hight = Math.max(pile, hight);
        }
        while (low < hight) {
            int middle = low + (hight - low) / 2;
            long time = finishTime(piles, middle);
            if (time > h) {
                low = middle + 1;
            } else {
                hight = middle;
            }
        }
        return low;
    }

    /**
     * 判断耗时时间
     * @param piles
     * @param k
     * @return
     */
    public long finishTime(int[] piles, int k) {
        long time = 0;
        for (int pile : piles) {
            int t = (pile + k - 1) / k;
            time = time + t;
        }
        return time;
    }
}

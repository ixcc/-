package day;

/**
 * 提莫攻击
 */
public class day495 {

    /**
     * 一次遍历模仿规则
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = duration, poisoned = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] <= poisoned) {
                count -=  poisoned + 1 - timeSeries[i];
            }
            count += duration;
            poisoned = timeSeries[i] + duration - 1;
        }
        return count;
    }
}

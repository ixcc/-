package day;

/**
 * 最多能排序的块
 */
public class day769 {

    /**
     * 判断下标和与值之和是否匹配
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int vSum = 0;
        int iSum = 0;
        for (int i = 0; i < arr.length; i++) {
            vSum += arr[i];
            iSum += i;
            if (vSum == iSum) {
                res++;
            }
        }
        return res;
    }
}

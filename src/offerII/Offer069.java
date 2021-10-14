package offerII;

/**
 * 山峰数组的最大值
 */
public class Offer069 {

    /**
     * 二分法
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        if (len == 3) {
            return 1;
        }
        int l = 1, r = len - 2;
        while (l <= r) {
            int m = (r - l)/2 + l;
            if (arr[m] > arr[m - 1] && arr[m] > arr[m + 1]) {
                return m;
            } else if (arr[m] > arr[m - 1] && arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return 0;
    }
}

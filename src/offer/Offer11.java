package offer;

/**
 * 旋转数组的最小数字
 */
public class Offer11 {

    /**
     * 以最左边为对齐点
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int left = 0 , right = numbers.length - 1;
        int mid = 0;
        while (left <= right) {
            // 如果子序列是从小到大有序即最小为最左
            if (numbers[left] < numbers[right]) {
                return numbers[left];
            }
            mid = left + (right - left)/2;
            if (numbers[left] < numbers[mid]) {
                // 最左小于mid--最小值在[Mid,right]范围中
                left = mid + 1;
            } else if (numbers[left] > numbers[mid]) {
                // 最左大于mid--最小值在[left + 1, mid]中
                right = mid; // 避免mid为最小错过最小情况
                left++; // left已经不可能为最小所以加一
            } else {
                // 相等则跳过最左
                left++;
            }
        }
        return numbers[mid];
    }

    /**
     * 以最右边为对齐点
     * @param numbers
     * @return
     */
    public int minArray2(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int left = 0 , right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (numbers[mid] < numbers[right]) {
                // 如果mid比最右小--最小值在[left,mid]中
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                // 如果mid比最右大--最小值在【mid,right】中
                left = mid + 1;
            } else {
                // 相等--跟新最右值
                right--;
            }
        }
        return numbers[left];
    }
}

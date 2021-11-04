package day;

/**
 * 有效的完全平方数字
 */
public class day367 {

    /**
     * 二分法
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long left = 1, right = num;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long square = mid * mid;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else if (square > num) {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 暴力
     * @param num
     * @return
     */
    public boolean isPerfectSquare2(int num) {
         long x = 1, square = 1;
         while (square <= num) {
             if (square == num) {
                 return true;
             }
             ++x;
             square = x * x;
         }
         return false;
    }

}

package day;

/**
 * 有限的回旋镖
 */
public class day1037 {


    /**
     *「三点各不相同且不在一条直线上」等价于「这两个向量的叉乘结果不为零」
     * @param points
     * @return
     */
    public static boolean isBoomerang(int[][] points) {
        int[] vOne = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] vTwo = {points[2][0] - points[1][0], points[2][1] - points[1][1]};
        return vOne[0] * vTwo[1] - vOne[1] * vTwo[0] != 0;
    }
}

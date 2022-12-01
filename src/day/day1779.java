package day;

/**
 * 找到相近的 x 和 y 的点
 */
public class day1779 {

    /**
     * 模拟
     * @param x
     * @param y
     * @param points
     * @return
     */
    public int nearestValidPoint(int x, int y, int[][] points) {
        int count = -1, index = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int temp = Math.abs(points[i][0] -  x) + Math.abs(points[i][1] - y);
                if (count == -1 || count > temp) {
                    count = temp;
                    index = i;
                }
            }
        }
        return index;
    }
}

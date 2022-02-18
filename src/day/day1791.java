package day;

/**
 * 找出星形图的中心点
 */
public class day1791 {

    /**
     * 对比前两对重复的元素
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        int center = 0;
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            center = edges[0][0];
        } else if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1]) {
            center = edges[0][1];
        }
        return center;
    }
}

package day;

/**
 * 写字符串需要的行数
 */
public class day806 {

    /**
     * 一次遍历
     * @param widths
     * @param s
     * @return
     */
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int count = 0;
        int[] arr = new int[2];
        for (int i = 0; i < s.length(); i++) {
            int temp = widths[s.charAt(i) - 'a'];
            count += temp;
            // 多少行
            if (count > 100) {
                lines++;
                count = temp;
            }
        }
        arr[0] = lines;
        arr[1] = count;
        return arr;
    }
}

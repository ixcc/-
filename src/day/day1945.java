package day;

/**
 * 字符串转换数字之后的合
 */
public class day1945 {
    public static void main(String[] args) {
        System.out.println(getLucky("iaozzbyqzwbpurzze", 2));
    }

    /**
     * 模拟
     * @param s
     * @param k
     * @return
     */
    public static int getLucky(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a' + 1;
            if (temp >= 10) {
                count += temp / 10;
            }
            count += temp % 10;
        }
        while (k > 1) {
            int sum = 0;
            for (int j = 0; count >= 10; j++) {
                sum += count %10;
                count = count/10;
            }
            sum += count;
            count = sum;
            k--;
        }
        return count;
    }
}

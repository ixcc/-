package day;

public class day7 {

    // 整数反转
    public int reverse(int x) {
        long n = 0; // 可能存在越界，所以得用Long类型接收
        while (x > 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int)n == n ? (int) n : 0;
    }
}

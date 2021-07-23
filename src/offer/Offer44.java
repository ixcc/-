package offer;

public class Offer44 {

    public int findNthDigit(int n) {
        int digit = 1; // 位数
        long start = 1; // 起点数
        long count = 9; // 总数
        while (n > count) {
            n -= count;
            digit++;
            start *= 10;
            count += digit * start * 9;
        }
        // 找到n在那个数字
        long num = start + (n - 1)/digit;
        // 找到n在该数字的那个字符
        String str = Long.toString(num);
        return str.charAt((n - 1) % digit) - '0';
    }
}

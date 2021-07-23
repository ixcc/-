package offer;

public class Offer43 {

    public int countDigitOne(int n) {
        int count = 0; // 为1的总和
        long digit = 1; // 10的次方
        while (n/digit != 0){
            long high = n / (digit * 10); // 高位
            long cur = (n / digit) % 10; // 当前位
            long low = n - (n / digit) * digit; // 低位
            if (cur == 0) {
                count += high * digit;
            } else if (cur == 1) {
                count += high * digit + (low + 1);
            } else {
                count += (high + 1) * digit;
            }
            digit = digit * 10; // 位置因素找下一位
        }
        return count;
    }
}

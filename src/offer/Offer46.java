package offer;

public class Offer46 {

    public int translateNum(int num) {
        int a = 1, b = 1;
        int x, y  = num % 10;
        while (num != 0) {
            num = num/10; // 遍历数字
            x = num % 10; // 获取下一位数字
            int temp = x * 10 + y; // 临时变量判断是否可以组合
            int c = (temp >= 10 && temp <= 25) ? a + b : a; // 判断是否符合可以组合的条件
            b = a;
            a = c;
            y = x; // 遍历到下一位数字继续判断
        }
        return a;
    }
}

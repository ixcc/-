package offer;

public class Offer65 {

    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1; // 进位计算
            a ^= b; // a与b异或计算得某位和得结果值
            b = c; // b替换成进位
        }
        return a; // 返回最终结果a
    }

    public int add2(int a, int b) {
        // 递归最终返回结果a
        if (b == 0) {
            return a;
        }
        return  add(a ^ b,(a & b) << 1);
    }
}

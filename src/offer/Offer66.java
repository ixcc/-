package offer;

public class Offer66 {

    public int[] constructArr(int[] a) {
        // 边界值处理
        if (a.length == 0) {
            return new int[0];
        }
        // 定义返回乘积数组B
        int[] b = new int[a.length];
        b[0] = 1; // 初始化首位为1便于后面相乘
        int temp = 1; // 定义一个变量用于记录反向遍历数组时的乘积
        // 正向遍历数组，记录i值左边所有数值的乘积
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        // 反向遍历数组，记录i值右边所有数值的乘积
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1]; // 记录i位后数值乘积变量
            b[i] *= temp; // 更新i位乘积和为= i左边乘积 * i右边乘积
        }
        // 返回乘积结果b
        return b;
    }
}

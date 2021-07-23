package offer;

public class Offer56I {

    public int[] singleNumbers(int[] nums) {
        int ret = 0; // 存储数组中所有值异或后的结果--即不同的两个数字异或后的值
        for (int num : nums) {
            ret ^= num;
        }
        int mask = 1; // 找到两个不同数字在二进制表达式中不同位--即第一个为1的位置
        while ((mask & ret) == 0) {
            mask <<= 1; // 某位相同即mask二进制左移一位
        }
        int a = 0, b = 0; // 定义变量记录不同的两个数字
        for (int num : nums) {
            // 将数组分为两组--每个数组中的值与mask做&操作判断是否==0
            if ((num & mask) == 0) {
                a ^= num; // 第一个不同的值
            } else {
                b ^= num; // 第二个不同的值
            }
        }
        // 返回两个不同的值数组
        return new int[]{a, b};
    }
}

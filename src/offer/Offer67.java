package offer;

public class Offer67 {

    public int strToInt(String str) {
        // 去掉空格
        char[] c = str.trim().toCharArray();
        // 判断为空边界返回
        if (c.length == 0) {
            return 0;
        }
        // 定义返回数值
        int res = 0;
        // 定义辅助变量
        int sign = 1;
        int i = 1;
        int boundary = Integer.MAX_VALUE / 10;
        // 首字符是否符号或者数字判断
        if (c[0] == '-') {
            // 首字符为负则最后返回负数
            sign = -1;
        } else if (c[0] != '+') {
            // 首字符不为正则从0开始遍历数组
            i = 0;
        }
        for (int j = i; j < c.length; j++) {
            // 是否为数字判断
            if (c[j] < '0' || c[j] > '9') {
                break; // 非数字直接返回
            }
            // 数字是否越界判断
            if (res > boundary || res == boundary && c[j] > '7') {
                // 数值越界则根据符号返回最大值或者最小值
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 满足所有条件计算res
            res = res * 10 + (c[j] - '0');
        }
        // 返回符号位*数值
        return sign * res;
    }
}

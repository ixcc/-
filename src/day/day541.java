package day;

/**
 * 反转字符串II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class day541 {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        char[] array = s.toCharArray();
        for (int i = 0; i < len; i += 2*k) {
            reverse(array, i, Math.min(i + k, len) - 1);
        }
        return new String(array);
    }

    public static void reverse(char[] array, int left, int right) {
        while (left <= right) {
            char temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }
}

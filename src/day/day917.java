package day;

/**
 * 仅仅反转字母
 */
public class day917 {

    /**
     * 双指针
     * @param s
     * @return
     */
    public String reverseOnlyLetters(String s) {
        int len = s.length();
        // 转换成字符数组
        char[] arr = s.toCharArray();
        int left = 0, right = len - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(arr[left])) {
                left++;
            }
            while (left < right && !Character.isLetter(arr[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        return new String(arr);
    }

    public void swap(char[] arr, int left, int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

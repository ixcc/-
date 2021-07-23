package day;

public class day28 {

    public static void main(String[] args) {
        System.out.println(strStr3("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int left = 0, right = 0;
        boolean flag = false;
        while (left < haystack.length()) {
            if (flag) {
                if (haystack.charAt(left) == needle.charAt(right) && right == needle.length() - 1) {
                    return left - needle.length() + 1;
                } else if (haystack.charAt(left) == needle.charAt(right)){
                    right ++;
                } else if (haystack.charAt(left) == needle.charAt(0)) {
                    right = 1;
                } else {
                    right = 0;
                    flag = false;
                }
            } else {
                if (haystack.charAt(left) == needle.charAt(right) && right == needle.length() - 1) {
                    return left - needle.length() + 1;
                } else if (haystack.charAt(left) == needle.charAt(right)) {
                    flag = true;
                    right++;
                }
            }
            left++;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle){
        if (needle.equals("")) {
            return 0;
        }
        int m = haystack.length() - 1, n = needle.length() - 1;
        for (int i = 0; i <= m - n; i++) {
            boolean flag = true;
            for (int j = 0; j <= n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr3(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int left = 0, right = 0, index = 0;
        while (right < haystack.length() && index < needle.length()) {
            if (haystack.charAt(right) != needle.charAt(index)) {
                left++;
                right = left;
                index = 0;
            } else {
                right++;
                index++;
            }
        }
        return index == needle.length() ? left : -1;
    }
}

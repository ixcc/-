package day;

public class day5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        int len = 0;
        String str = "";
//        for (int i = s.length() - 1; i >= 0 ; i--) {
//            for (int j = i; j >= 0; j--) {
//                if (i - j > len && IsPalindrome(s.substring(j, i))) {
//                    len = i - j;
//                    str = s.substring(j, i);
//                }
//            }
//        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (j - i >= len && IsPalindrome(s.substring(i, j + 1))) {
                    len = j - i;
                    str = s.substring(i, j + 1);
                }
            }
        }
        return str;
    }

    public static Boolean IsPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

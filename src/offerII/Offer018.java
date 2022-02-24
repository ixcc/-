package offerII;

/**
 * 有效的回文
 */
public class Offer018 {

    /**
     * 双指针
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s.equals(" ")) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)) ) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)) ) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
